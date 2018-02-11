import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.*;

public class hashMapString {
	//static String str = "key1=value1 , key2=value2 ,key3=[key4=value4,key5=value5,key6=[key7=value7] ],key8=value8";
	static String str = "key1=value1,key2=value2,key3=[key4=value4,key5=value5,key6=[key7=value7]],key8=value8";

	public static HashMap<String, Object> parse(String input){
		HashMap<String, Object> map = new HashMap<String, Object>();
		String s = input;
		System.out.println(s);
		
		for (; s != null && s.length() > 0;)
		{
			int eqI = s.indexOf('=');
			int dotI = s.indexOf(',');
			int leftI = s.indexOf('[');
			int rightI = s.indexOf(']');
			String key = s.substring(0, eqI);
			System.out.println(key);
			System.out.println(dotI);
			System.out.println(leftI);
			System.out.println(rightI);
			if (dotI < leftI)
			{
				int valEnd =  min(dotI, rightI);

				String val = s.substring(eqI + 1, valEnd);
				map.put(key, val);
				s = s.substring(valEnd + 1);
			}
			else // [ .... ,
			{
				int lastRightI = s.lastIndexOf(']');

				map.put(key, parse(s.substring(leftI+1, lastRightI)));
				s = s.substring(lastRightI + 1);
			}
			if (s.charAt(0) == ',')
				s = s.substring(1);
		}
		return map;
	}

	public static void main(String []args) {
		System.out.println(str);
		System.out.println(str.trim());
		parse(str.trim());
	}
}
