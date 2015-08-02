package wiki;

import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] a) {
	    Map map = new HashMap();
	    map.put("key1", "value1");
	    map.put("key2", "value2");
	    map.put("key3", "value3");
	    Map map2 = new HashMap();
	    map2.put("key2", "value2");
	    map2.put("key1", "value1");
	    map2.put("key3", "value3");
	    System.out.println(map.equals(map2));
	  }
}
