import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Eureka {
	
	private static void testing(long a, long b, long[] res) {
        assertEquals(Arrays.toString(res), 
                     Arrays.toString(sumDigPow(a, b).toArray()));
    }
	
	@Test
    public void test() {
        System.out.println("Basic Tests");
        testing(1, 10, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100,  new long[] {89});
        testing(90, 100, new long[] {});
        testing(90, 150, new long[] {135});
        testing(50, 150, new long[] {89, 135});
        testing(10, 150, new long[] {89, 135});
    }
	
	public static List<Long> sumDigPow(long a, long b) {
		
		char[] number;
		List<Long> outputList = new ArrayList<Long>();

		for(long i =a; i<=b;i++) {
        	number=String.valueOf(i).toCharArray();
        	long sum=0;
    		long product=0;
    		int place=0;

    		for(char ch: number) {
    			place++;
    			sum = sum+Character.getNumericValue(ch);
    			product = (long) (product+Math.pow(Character.getNumericValue(ch),place));
    		}
    		if(sum==product)
    			outputList.add(i);
        }
		return outputList;
    }

}
