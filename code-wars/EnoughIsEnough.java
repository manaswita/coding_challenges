import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class EnoughIsEnough {

	public static int[] deleteNth(int[] elements, int maxOccurrences) {

		int[] finalList = null;
		int i =0;
		int freq=0;

		for (int n : elements) {
			freq = frequency(finalList, finalList.length, n);
			if(freq < maxOccurrences) {
				finalList[i]= n;
				i++;
			}
		}
		return finalList;
	}

	public static int frequency(int a[], int n, int x) {
		int count = 0;
		for (int i = 0; i < n; i++)
			if (a[i] == x)
				count++;
		return count;
	}

	@Test
	public void deleteNth() throws Exception {
		assertArrayEquals(new int[] { 20, 37, 21 }, deleteNth(new int[] { 20, 37, 20, 21 }, 1));
		assertArrayEquals(new int[] { 1, 1, 3, 3, 7, 2, 2, 2 }, deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3));
		assertArrayEquals(new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
				deleteNth(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3));
		assertArrayEquals(new int[] { 1, 1, 1, 1, 1 }, deleteNth(new int[] { 1, 1, 1, 1, 1 }, 5));
		assertArrayEquals(new int[] {}, deleteNth(new int[] {}, 5));

	}

}
