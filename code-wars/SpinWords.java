import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.StringTokenizer;

import org.junit.Test;

public class SpinWords {

	public String spinWords(String sentence) {
		StringTokenizer stringTokens = new StringTokenizer(sentence, " ");
		String loopString;
		String reverse = "";
		StringBuilder returnString = new StringBuilder();
		
		while(stringTokens.hasMoreTokens()) {
			reverse = "";
			loopString = stringTokens.nextToken();
			if(loopString.length()>=5) {
				for(int i = loopString.length() - 1; i >= 0; i--)
				{
				reverse = reverse + loopString.charAt(i);
				}
				returnString.append(reverse);
			}else {
				returnString.append(loopString);
			}
			returnString.append(" ");
		}
		return returnString.toString().trim();
	}

	@Test
	public void test() {
		assertEquals("emocleW", new SpinWords().spinWords("Welcome"));
		assertEquals("Hey wollef sroirraw", new SpinWords().spinWords("Hey fellow warriors"));
	}

}
