import java.util.HashMap;
import java.util.Map;
import static java.lang.Math.*;

public class hashMapString {
	//static String str = "key1=value1 , key2=value2 ,key3=[key4=value4,key5=value5,key6=[key7=value7] ],key8=value8";
	static String str = "key1=value1,key2=value2,key3=[key4=value4,key5=value5,key6=[key7=value7]],key8=value8";

	public static HashMap<String, Object> parse(String input){
		HashMap<String, Object> map = new HashMap<String, Object>();
		String s = input;
		//System.out.println(s);
		
		for (; s != null && s.length() > 0;)
		{
			int eqI = s.indexOf('=');
			int dotI = s.indexOf(',');
			int leftI = s.indexOf('[');
			int rightI = s.indexOf(']');
			String key = s.substring(0, eqI);
			//System.out.println(key);
			//System.out.println(dotI);
			//System.out.println(leftI);
			//System.out.println(rightI);
			if (s.charAt(eqI+1)!='[')
			{
				int valEnd =  0;
				if(dotI>0&&rightI>0)
					valEnd = min(dotI, rightI);
				else if (dotI>0&&rightI<0)
					valEnd = dotI;
				else if (dotI<0&&rightI>0)
					valEnd = rightI;
				else
					valEnd = s.length();

				String val = s.substring(eqI + 1, valEnd);
				map.put(key, val);
				if (dotI < 0 && rightI < 0)
					s = "";
				else
					s = s.substring(valEnd + 1);
			}
			else // [ .... ,
			{
				int lastRightI = s.lastIndexOf(']');

				map.put(key, parse(s.substring(leftI+1, lastRightI)));
				s = s.substring(lastRightI + 1);
			}
			if (s.length() > 0 && s.charAt(0) == ',')
				s = s.substring(1);
		}
		return map;
	}

	public static void main(String []args) {
		System.out.println("input string: " + str);
		//System.out.println(str.trim());
		HashMap map = parse(str.trim());

		System.out.println();
		System.out.println("output hashMap: " + map.toString());
	}
}
