import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class CountLetters {
	
private double precision = 0.0000000000001;
    
    @Test
    public void sampleTestCases() {
        assertEquals(1.0,findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }
	
	public static double findUniq(double arr[]) {
		Map<Double, Integer> numMap = new HashMap<Double, Integer>();
		int oldValue = 0;
		double returnValue = 0;
	      for (double n: arr) {
	    	  if(numMap.containsKey(n)) {
	    		  oldValue = numMap.get(n);
	    		  numMap.put(n, oldValue+1);
	    	  }else {
	    		  numMap.put(n, 1);
	    	  }
	      }
	      
	      for (Map.Entry<Double,Integer> set : numMap.entrySet()) {
			   if(set.getValue() == 1) {
				   returnValue = set.getKey();
			   }
			}
	      return returnValue;
	    }

}
