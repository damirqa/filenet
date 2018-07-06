package ru.damirqa.service;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			System.out.println("nes");
			loadingData("PERSON");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	 
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(JDBC_URL);
	}
	
	private void loadingData(String tableName) {
		try (Connection connection = getConnection()) {
			if (!hasExistsTable(connection, tableName)) {
				System.out.println("nen");
				createPersonTable(connection, tableName);
			}
			System.out.println("ned");
		} catch (SQLException e) {
			e.getMessage();
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
	
	private void createPersonTable(Connection connection, String tableName) throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("CREATE TABLE " + tableName + 
				"(id INT, firstName VARCHAR(50), middleName VARCHAR(50), lastName VARCHAR(50), position VARCHAR(50))");
		preparedStatement.execute();
		System.out.println("Таблица создана");
	}
}
