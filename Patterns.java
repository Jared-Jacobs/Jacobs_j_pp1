
import java.util.regex.*;
import java.util.HashMap;
/**
 * This classes uses REGEX to find IP addresses and usernames
 * and store them into 2 different hashmaps.
 * @author Jared Jacobs
 * @version 1.0
 * Programming Project One
 * CS322 - Compiler Construction
 * Spring 2019
 */

public class Patterns
{

		HashMap<String, Integer> IpMap = new HashMap<>();
		HashMap<String, Integer> UserMap = new HashMap<>();

	//Creates 2 HashMaps to later be called in Application.java to map
	//the Ip Addresses amd Usernames aswell as frequencies.
	public Patterns()
	{
		 IpMap = new HashMap<>();
		 UserMap = new HashMap<>();
	}

	//Returns IpMap when called
	public HashMap<String, Integer> getIpMap()
	{
		return IpMap;
	}
	//Returns UserMap when called.
	public HashMap<String, Integer> getUserMap()
	{
		return UserMap;
	}

	//Method to return the number of IP entrier in the IpMap
	public int getIpMapSize()
	{
		return IpMap.size();
	}

	//Method to return the number of Usernames in the UserMap
	public int getUserMapSize()
	{
		return UserMap.size();
	}

	//Method that uses REGEX to find IP Addresses and store them in regexIp.
	//Also looks for Usernames searching for the keyword user and grabbing the word 'user'
	//aswell as the username and storing it in regexUser.
	public void Patterns(String str)
	{
		Matcher regexIp = Pattern.compile("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b").matcher(str); 

		Matcher regexUser = Pattern.compile("user\\s\\w+").matcher(str);

	//While loop that continues to loop aslong as it finds a Ip and stores the IP found.
	//Then checked if already mapped, if so add 1 to the frequency, if not store and make frequency 1.
	while(regexIp.find())
	{
		String ipPattern = regexIp.group();
		if(IpMap.containsKey(ipPattern))
		{
			IpMap.put(ipPattern, IpMap.get(ipPattern) + 1);
		}
		else
		{
			IpMap.put(ipPattern,1);
		}
	}
	//While loops counting occurance of usernames, also makes a string that gets rid if
	//the word user(which I used to find the actual username)
	while(regexUser.find())
	{
		String userPattern = regexUser.group();
		String user = userPattern.substring(5);
		if(UserMap.containsKey(userPattern))
		{
			UserMap.put(user, UserMap.get(user)+ 1);

		}else
		{
			UserMap.put(user, 1);
		}

	}
	}
}
