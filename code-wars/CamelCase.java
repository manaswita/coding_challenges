import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CamelCase {

	public static String camelCase(String str) {
		StringBuffer returnString = new StringBuffer();
		char aChar;
		boolean isSpace = false;
		for(int i = 0; i<str.length();i++) {
			aChar = str.charAt(i);
			if(i==0) {
				if(aChar >= 97){
					aChar = (char)( (aChar - 32) ); 
					returnString.append(aChar); 
					continue;
				}
			}
			if(Character.isWhitespace(aChar)) {
				isSpace = true;
				continue;
			}
			if(isSpace) {
				if(aChar >= 97){
					aChar = (char)( (aChar - 32) ); 
					returnString.append(aChar);
				}
				isSpace = false;
				continue;
			}
			returnString.append(aChar);
		}
        return returnString.toString();
    }
	
	@Test
    public void testTwoWords() {
        assertEquals("TestCase", camelCase("test case"));
    }

    @Test
    public void testThreeWords() {
        assertEquals("CamelCaseMethod", camelCase("camel case method"));
    }

    @Test
    public void testLeadingSpace() {
        assertEquals("CamelCaseWord", camelCase(" camel case word"));
    }

    @Test
    public void testTrailingSpace() {
        assertEquals("SayHello", camelCase("say hello "));
    }

    @Test
    public void testSingleLetter() {
        assertEquals("Z", camelCase("z"));
    }

    @Test
    public void testTwoSpacesBetweenWords() {
        assertEquals("AbC", camelCase("ab  c"));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", camelCase(""));
    }
}
