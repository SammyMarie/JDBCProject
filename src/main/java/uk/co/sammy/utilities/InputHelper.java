package uk.co.sammy.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class InputHelper {

	public static String getInput(String prompt){

		BufferedReader buffRead = new BufferedReader(new InputStreamReader(System.in));

		out.println(prompt);
		out.flush();

		try {
			return buffRead.readLine();
		} catch (IOException ioe) {

			return "Error: " + ioe.getMessage();
		}
	}

	public static String getStringInput(String prompt){

		String input = getInput(prompt);

		return input;
	}

	public static int getInputs(String prompt) throws NumberFormatException {

		String input = getInput(prompt);
		return Integer.parseInt(input);

	}
}