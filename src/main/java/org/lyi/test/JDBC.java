package org.lyi.test;

import java.sql.Connection;
import java.sql.DriverManager;

//pom.xml�� ���� JDBC Jar ������ �߰� �� ������ ���̽��� ���� Ȯ�ο� �׽�Ʈ �ڵ� �ۼ� > ���� Ȯ��

public class JDBC {
	// Driver �ε� ����
	String driver = "com.mysql.jdbc.Driver";
	// url ����
	String url = "jdbc:mysql://localhost:3306/exam?serverTimezone=Asia/Seoul";
	// userID ����
	String user = "root";
	// password ����
	String pw = "1234";
	// ����̺� �ε�
	
	// JDBC ���� �׽�Ʈ �� �޼ҵ�
	public void testConnection() throws Exception {
	
		Class.forName(driver);
		try(Connection con = DriverManager.getConnection(url,user,pw)){
			System.out.println("DB���Ἲ��~");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}


