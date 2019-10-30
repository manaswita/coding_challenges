import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.junit.Test;

public class StringToCamelCase {
	
	@Test
    public void testSomeUnderscoreLowerStart() {
      String input = "the_Stealth_Warrior";
      System.out.println("input: "+input);      
      assertEquals("theStealthWarrior", toCamelCase(input));
    }
    @Test
    public void testSomeDashLowerStart() {
      String input = "the-Stealth-Warrior";
      System.out.println("input: "+input);      
      assertEquals("theStealthWarrior", toCamelCase(input));
    }
	
	static String toCamelCase(String s){
		System.out.println( new BigInteger(130, new SecureRandom()).toString(32));
	    return "";
	  }

}
