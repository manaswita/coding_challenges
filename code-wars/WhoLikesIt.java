import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class WhoLikesIt {
	
	@Test
    public void staticTests() {
        assertEquals("no one likes this", whoLikesIt());
        assertEquals("Peter likes this", whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
	
	public static String whoLikesIt(String... names) {
		int size = names.length;
		switch(size){
		
		case 0: return "no one likes this";
		case 1: return names[0] +" likes this";
		case 2: return names[0] +" and "+ names[1] +" like this";
		case 3: return names[0] +", "+names[1] +" and "+ names[2] +" like this";
		default: return names[0] +", "+names[1] +" and "+ (size-2) +" others like this";
			
		}
    }

}
