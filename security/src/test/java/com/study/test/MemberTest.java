package com.study.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml", "file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MemberTest {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void test() {
		String sql = "insert into spring_member(userid,userpw,username) values(?,?,?)";
		
		for(int i=0;i<100;i++) {
			try {
				Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(2, encoder.encode("pw"+i));
				
				if(i<80) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(3, "일반회원"+i);
				}else if(i<90) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(3, "매니저"+i);
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(3, "관리자"+i);
				}
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
