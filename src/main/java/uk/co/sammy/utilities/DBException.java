package uk.co.sammy.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.*;

public class DBException {

	public static void processException(SQLException sql){

		err.println("Error Message: " + sql.getMessage());
		err.println("Error Code: " + sql.getErrorCode());
		err.println("SQL state: " + sql.getSQLState());
	}
}