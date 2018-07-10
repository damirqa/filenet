package ru.damirqa.service;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.damirqa.model.staff.Person;
import ru.damirqa.service.jaxb.EmployeesWrapJAXB;
import ru.damirqa.storage.Employees;

public class DataBaseService {
	
	public static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	
	public static final String JDBC_URL = "jdbc:derby:filenetdb;create=true";
	
	private static Logger logger = LoggerFactory.getLogger(DataBaseService.class);
	
	public static void main(String[] args) {
		DataBaseService baseService = new DataBaseService();
	}
	
	 public DataBaseService() {
		 try {
			Class.forName(DRIVER);
			loadingData("PERSON");
		} catch (ClassNotFoundException e) {
			logger.info(e.getMessage());
		}
	}
	 
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL);
	}
	
	private void loadingData(String tableName) {
		try (Connection connection = getConnection()) {
			if (!hasExistsTable(connection, tableName)) {
				if (createPersonTable(connection, tableName)) {
					insertPersonDataToTable(connection);
				}
			}
		} catch (SQLException e) {
			logger.info(e.getMessage());
		}
	}
	
	private boolean hasExistsTable(Connection connection, String tableName) throws SQLException {
		
		DatabaseMetaData metaData = connection.getMetaData();
		ResultSet resultSet = metaData.getTables(null, null, "PERSON", null);
		
		while (resultSet.next()) {
			if (resultSet.getString("TABLE_NAME").equals(tableName)) {
				return true;
			}
		}
		return false;	
	} 
	
	private boolean createPersonTable(Connection connection, String tableName) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE " + tableName + 
				"(id INT, firstName VARCHAR(50), middleName VARCHAR(50), lastName VARCHAR(50), position VARCHAR(50))");
		return preparedStatement.execute();
	}
	
	private void insertPersonDataToTable(Connection connection) throws SQLException {
		
		Employees.setListOfEmployees(new File(Thread.currentThread().getContextClassLoader().getResource("emp.xml").getFile()), EmployeesWrapJAXB.class);
		
		String query = "INSERT INTO PERSON(id, firstName, middleName, lastName) VALUES(?, ?, ?, ?)";
		
		for (Person person : Employees.list) {
			try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {;
				preparedStatement.setInt(1, person.getId());
				preparedStatement.setString(2, person.getFirstName());
				preparedStatement.setString(3, person.getMiddleName());
				preparedStatement.setString(4, person.getLastName());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				logger.info(e.getMessage());
			}
		}
	}
	
	private void printResult(Connection connection) throws SQLException {
		String query = "SELECT * FROM PERSON";
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			System.out.println(resultSet.getString("ID") + " " + resultSet.getString("firstName") + " " +
					resultSet.getString("middleName") + " " + resultSet.getString("lastName"));
		}	
	}
}
