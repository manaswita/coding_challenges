import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class CamelCase2 {
	
	public static String camelCase(String str) {
		String[] childStrings = str.split(" ");
		StringBuilder returnString = new StringBuilder();
		for(String s: childStrings) {
			if (s.length()>0){
				returnString.append(s.replaceFirst(s.substring(0, 1), s.substring(0, 1).toUpperCase()));
			}
		}
		System.out.println(returnString.toString());
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
