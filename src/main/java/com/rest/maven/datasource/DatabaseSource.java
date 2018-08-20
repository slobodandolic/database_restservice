package com.rest.maven.datasource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseSource {

	public Connection getConnection() {

		Connection connection = null;

		String dbase = "jdbc:mysql://localhost:3306/dbkodovi?useSSL=false";
		String dbpass = "root";
		String dbuser = "root";

		try {
			connection = DriverManager.getConnection(dbase, dbuser, dbpass);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			System.out.println("Connection succesfull");

		} catch (Exception e) {
			System.out.println("Connection fail");
		}
		
		return connection;

	}

}
