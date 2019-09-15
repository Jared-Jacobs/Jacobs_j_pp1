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

		//Allows us to call Patterns.java methods and creates/sets totalLines to 0.
		int totalLines = 0;
		Patterns patterns = new Patterns();

		//Scans log file for the size of the file checking for IPs and usernames
		//aswell as adds 1 to totalLines for each line it parses through
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

		//Print flag 1 outputs the IpMap which contains the IP's and Frequency for each IP
		if(args[1].equals("1"))
		{
			patterns.getIpMap().forEach((k,v)->System.out.println("IP Address: " + k + "; : " + v));
		}

		//Print flag 2 outputs the UserMap which contains all the Usernames and Frequency for each User.
		if(args[1].equals("2"))
		{
			patterns.getUserMap().forEach((k,v)->System.out.println(k + ": " + v));
		}
		//Final Output results for total Lines, Ip Addresses and usernames.
		System.out.println(totalLines + " total lines were parsed.");
		System.out.println("There are " + patterns.getIpMapSize() + " total Ip Addresses in the log.");
		System.out.println("There are " + patterns.getUserMapSize() + " total Users in the log.");
	}
}
