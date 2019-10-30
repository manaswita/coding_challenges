import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class PersistentBugger {

	@Test
	public void BasicTests() {
		System.out.println("****** Basic Tests ******");
		assertEquals(3, persistence(39));
		assertEquals(0, persistence(4));
		assertEquals(2, persistence(25));
		assertEquals(4, persistence(999));
	}

	public static int persistence(long n) {
		char[] numericArray = String.valueOf(n).toCharArray();
		if(numericArray.length == 1) return 0;
		int product = 1;
		int count = 0;
		do {
			product=1;
			for (char ch : numericArray) {
				product = product * Character.getNumericValue(ch);
			}
			numericArray = String.valueOf(product).toCharArray();
			count++;
		}
		while (numericArray.length > 1);
		return count;
	}

}
