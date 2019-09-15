import java.util.*;
import java.io.*;

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

		int totalLines = 0;

		Patterns patterns = new Patterns();

		try
		{
			Scanner scan = new Scanner(new File(args[0]));
			while(scan.hasNextLine())
			{
				totalLines++;
				patterns.Patterns(scan.nextLine());
			}

		}
		catch (FileNotFoundException f)
		{
			f.printStackTrace();
		}

		if(args[1].equals("1"))
		{
			patterns.getIpMap().forEach((k,v)->System.out.println("IP Address: " + k + "; : " + v));
		}


		if(args[1].equals("2"))
		{
			patterns.getUserMap().forEach((k,v)->System.out.println(k + ": " + v));
		}
		System.out.println(totalLines + " total lines were parsed.");
		System.out.println("There are " + patterns.getIpMapSize() + " total Ip Addresses in the log.");
		System.out.println("There are " + patterns.getUserMapSize() + " total Users in the log.");
		//System.out.println(input);
		//Matcher match = pattern.matcher(input);
		//while(match.find()) {
		//	System.out.println("IP: " +match.group());
		//}

	}
}
