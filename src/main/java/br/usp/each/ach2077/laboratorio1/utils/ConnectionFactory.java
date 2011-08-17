package br.usp.each.ach2077.laboratorio1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:postgresql://147.103.80.112:8080/laboratorio1", "felipe.pierin", "felipe.pierin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
