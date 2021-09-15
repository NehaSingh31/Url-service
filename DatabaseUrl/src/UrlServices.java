import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;
import org.json.simple.JSONObject;
import java.util.Map.Entry;
public class UrlServices {
	 static HashMap<String, String> map=new HashMap<>();
	 static int count=0;
public static void main(String args[])
{
	Scanner scan=new Scanner(System.in);
	for(int i=0;i<args.length;i++)
	{
		String url=args[i];
		 System.out.println("print the url "+url);
		String uniqueID = UUID.randomUUID().toString();
		 System.out.println("print uniqeId Generate "+uniqueID);
		 
		 // call storeurl method to store uniqeId and url in a table
		storeUrl(uniqueID,url);
		count++;
	}
	//using scanner for put the user input in getUniqeID method
	String urlString=scan.next();
	
	// call getUniqeID method to get the uniqeID from the map or table
	//getUniqeID method taking URl parameter as user input
	String printUniqeID=getUniqeId(urlString);
	System.out.println(printUniqeID);
	
	
	String urlCount=scan.next();
	// call getCount method to returns latest count 
	int returnCount=getCount(urlCount);
	
	//print latest count
	System.out.println(returnCount);
	
	// call getList method for return all key values in JSON format
	JSONObject list=getList();
	System.out.println("print all json data :"+list);
}
public static void storeUrl(String uniqeID,String url)
{
	map.put(uniqeID, url);
}
public static String getUniqeId(String urlString)
{
	String uniqekey=null;
	count++;
	for (Entry<String, String> entry : map.entrySet()) {
        if (entry.getValue().equals(urlString)) {
            uniqekey=entry.getKey();
            System.out.println("print uniqekey "+uniqekey);
            return uniqekey;
        }
    }
	return uniqekey;
}
public static int getCount(String urlCount)
{
	return count;
}

public static JSONObject getList()
{
	JSONObject json = new JSONObject();
	json.putAll( map );
	return json;
}
}
