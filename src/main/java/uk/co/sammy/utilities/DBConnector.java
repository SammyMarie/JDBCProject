package uk.co.sammy.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.*;

public class DBConnector {

	private static final String USERNAME = "dbuser";
	private static final String PASSWORD = "db";
	private static final String M_CONN_STRING = "jdbc:mysql://localhost/Trades";

	public static Connection getConnection(DBType dbType) throws SQLException{

		switch (dbType) {
		
			case MYSQL:
				return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);

			default:
				return null;
		}
	}

	public static void processException(SQLException sql){

		err.println("Error Message: " + sql.getMessage());
		err.println("Error Code: " + sql.getErrorCode());
		err.println("SQL state: " + sql.getSQLState());
	}
}