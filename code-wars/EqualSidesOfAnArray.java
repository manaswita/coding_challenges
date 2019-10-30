import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class EqualSidesOfAnArray {
	
	 @Test
	    public void test() {
	        assertEquals(1,findEvenIndex(new int[] {0,8}));
	        assertEquals(0,findEvenIndex(new int[] {8, 0}));
	        assertEquals(1,findEvenIndex(new int[] {1,100,50,-51,1,1}));
	        assertEquals(-1,findEvenIndex(new int[] {1,2,3,4,5,6}));
	        assertEquals(3,findEvenIndex(new int[] {20,10,30,10,10,15,35}));
	        assertEquals(-1,findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
	        assertEquals(1,findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
	        assertEquals(6,findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
	    }
	
	public static int findEvenIndex(int[] arr) {
		//if(arr.length<3) return -1;
		int sumForward = 0, sumBackward =0;
		
		for(int i=0;i<arr.length;i++) {
			sumForward=0;sumBackward =0;
			for(int j=0; j<i;j++) {
				sumForward = sumForward + arr[j];
			}
			for(int k=arr.length-1; k>i;k--) {
				sumBackward = sumBackward +arr[k];
			}
			if(sumBackward == sumForward) return i;
			
		}
	    return -1;
	  }

}
