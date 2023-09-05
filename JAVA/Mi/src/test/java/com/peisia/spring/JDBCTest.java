package com.peisia.spring;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;
import static org.junit.Assert.fail;

@Log4j
public class JDBCTest {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://staff2303.cafe24.com/staff2303", "staff2303", "staff7161")) {
			log.info(con);
			;
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}