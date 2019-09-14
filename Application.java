import java.util.*;
import java.util.regex.*;
/**
* Main Application that reads through the auth.log file and prints the file.
* @author Jared Jacobs
* @version 1.0
* Programming Project One
* CS322 - Compiler Construction
* Spring 2019
*/
public class Application{


	public static void main(String[] args){
		String authFile = "auth.log");
		String input= "";

		try {
			Scanner scan = new Scanner(authFile);
			while(scan.hasNextLine()) {
				input += scan.hasNextLine() + " ";
		}
		catch (FileNotFoundException f) {
			f.printStackTrace();
		}

		System.out.println(input);
		Pattern pattern = Pattern.compile(("(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)");
		Matcher match = pattern.matcher(input);
		while(match.find()) {
			System.out.println("IP: " +match.group());
		}

}
