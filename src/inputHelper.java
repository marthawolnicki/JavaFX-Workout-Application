import java.io.FileReader; 
import java.io.BufferedReader; 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map; 


public class inputHelper {
	private static Map <String, String> userMap =  new HashMap<String, String> (); 
	private String fileName;
	public inputHelper(String fileName) {
		this.fileName = fileName;
		getUsers(fileName);
	}

	public inputHelper() {	
	}

	public static boolean isCorrectCredentials(String loginName, String password) {
		// key: login name 
		// value: value associated with inputted key 

		String passwordForEnteredUsername = userMap.get(loginName); 

		if (passwordForEnteredUsername == null) {
			return false; 
		}

		if (passwordForEnteredUsername.equals(password)){
			return true; 
		}

		else {
			return false;
		}
	}


	public static void getUsers(String fileName) {
		String line = null; 

		try { 
			FileReader fileReader = new FileReader (fileName);

			BufferedReader bufferedReader = new BufferedReader(fileReader); 
			line = bufferedReader.readLine();

			while ( line!= null) {
				String[] pair = line.split(",");
				
				// enter information into user map
				if(pair.length == 2) {
					System.out.println(pair[0] + ", " + pair[1]);
					userMap.put(pair[0], pair[1]);	
				}

				line = bufferedReader.readLine(); 
			}// end while loop 	

			bufferedReader.close(); 
		}// end try 

		catch (IOException e) {
			e.printStackTrace();
		} // end catch 

	} // end getUsers function - fill Map with file data


	public static User getUserById(String enterUsername, String password) {
		return new User(enterUsername, password, 0, 0);
	}



	public boolean isGoodDoubleInput(String input) {
		try {
			Double.parseDouble(input); 
			return true; 

		}
		catch(NumberFormatException e) {
			return false; 
		}
	}



	public boolean isGoodIntInput(String input) {
		try {
			Integer.parseInt(input); 
			return true; 

		}
		catch(NumberFormatException e) {
			return false; 
		}
	}

	public void writeNewUserToFile(String username, String password) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			String content = username + "," + password + "\r\n"; 
			fw = new FileWriter(fileName, true);
			bw = new BufferedWriter(fw);
			bw.write(content); 
			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}// end writeNewUserToFile
} // end inputHelper class