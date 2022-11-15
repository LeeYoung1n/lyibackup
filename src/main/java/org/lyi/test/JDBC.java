package org.lyi.test;

import java.sql.Connection;
import java.sql.DriverManager;

//pom.xml을 통해 JDBC Jar 파일을 추가 및 데이터 베이스의 연결 확인용 테스트 코드 작성 > 이후 확인

public class JDBC {
	// Driver 로드 정보
	String driver = "com.mysql.jdbc.Driver";
	// url 정보
	String url = "jdbc:mysql://localhost:3306/exam?serverTimezone=Asia/Seoul";
	// userID 정보
	String user = "root";
	// password 정보
	String pw = "1234";
	// 드라이브 로드
	
	// JDBC 연결 테스트 용 메소드
	public void testConnection() throws Exception {
	
		Class.forName(driver);
		try(Connection con = DriverManager.getConnection(url,user,pw)){
			System.out.println("DB연결성공~");
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}


