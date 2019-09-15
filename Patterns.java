
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

	public Patterns()
	{
		 IpMap = new HashMap<>();
		 UserMap = new HashMap<>();
	}

	public HashMap<String, Integer> getIpMap()
	{
		return IpMap;
	}

	public HashMap<String, Integer> getUserMap()
	{
		return UserMap;
	}

	public int getIpMapSize()
	{
		return IpMap.size();
	}

	public int getUserMapSize()
	{
		return UserMap.size();
	}

	public void Patterns(String str)
	{
		Matcher regexIp = Pattern.compile("\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b").matcher(str); 

		Matcher regexUser = Pattern.compile("user\\s\\w+").matcher(str);

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
	while(regexUser.find())
	{
		String userPattern = regexUser.group();
		String usernames = userPattern.substring(5);
		if(UserMap.containsKey(userPattern))
		{
			UserMap.put(usernames, UserMap.get(usernames) + 1);

		}else
		{
			UserMap.put(usernames, 1);
		}

	}
	}
}
