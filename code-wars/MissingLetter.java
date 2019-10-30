import org.junit.Test;

public class MissingLetter {
	
	 @Test
	    public void exampleTests() {
	        assertEquals('e', findMissingLetter(new char[] { 'a','b','c','d','f' }));
	        assertEquals('P', findMissingLetter(new char[] { 'O','Q','R','S' }));
	    }

}
