import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Hashmap;
/**
 * This classes uses REGEX to find IP addresses and usernames
 * and store them into 2 different hashmaps.
 * @author Jared Jacobs
 * @version 1.0
 * Programming Project One
 * CS322 - Compiler Construction
 * Spring 2019
 */

public class PatternMatch
{

	//Declaring hashmaps for ip and usernames.
	Hashmap<Integer, String> ipMap = new HashMap(Integer, String>();
	Hashmap<Integer, String> userMap = new HashMap(Integer, String>();

	public PatternMatch()
	{
		ipMap = new HashMap<>();
		userMap = new HashMap<>();
	}

	public HashMap<String, Integer> getIpMap()
	{
		return ipMap;
	}


