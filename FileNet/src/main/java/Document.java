import java.util.Date;

// ����� "��������"

public abstract class Document implements Comparable<Document>{
	
	// ��� � ������?
	
	private int id; // ������������� ���������
	private String name; // �������� ���������
	private String text; // ����� ���������
	private int registrationNumber; // ��������������� ����� ���������
	private Date dateRegistration; // ���� ����������� ���������
	private String author; //����� ���������

}
