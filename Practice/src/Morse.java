import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Mo {
	public static int uniqueMorseRepresentations(String[] words) {
		String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
                ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--",
                "-..-","-.--","--.."};
		Set<String> setOfComparison = new HashSet();

		int transformation = -1;
//		int charIndex;
		
		for (String str : words) {
			String wordCode = "";
			for (int i = 0 ; i < str.length() ; i ++) {
				char c = str.charAt(i);
				int charIndex = (int)c - 97 ;
				wordCode = wordCode + morseCode[charIndex];
			}
			setOfComparison.add(wordCode);
			System.out.println("Encoded Word is : " + wordCode);
		}
		
		return setOfComparison.size();
	}
	
	
}
public class Morse {

	public static void main(String[] args) {
		String[] words = {"gin", "vfds", "gig", "sdg" , "gim"};
		int result = Mo.uniqueMorseRepresentations(words);
		System.out.println(result);

	}

}
