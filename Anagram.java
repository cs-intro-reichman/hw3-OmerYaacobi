import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Replace the following statement with your code
		str1 = preProcess(str1);
        str2 = preProcess(str2);

		if (str1.length() != str2.length()) {
			return false;
		}
		char [] letters1 = str1.toCharArray();
		char [] letters2 = str2.toCharArray();

		Arrays.sort(letters1); 
		Arrays.sort(letters2);

		String str1String = new String (letters1);
		String str2String = new String (letters2);

		if (str1String.equals(str2String)){
			return true;
		}
		
		return false;
			}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	private static String preProcess(String str) {
		// Replace the following statement with your code
		String sym = " ?!";
		String strOut = "";
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			if (sym.indexOf(c) == -1) {
				strOut = strOut + c;
			}
			i++;
		}
		i = 0;
		String strOutLow = "";
		String up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while (i < strOut.length()) {
			char c = strOut.charAt(i);
			if (up.indexOf(c) == -1) {
				strOutLow = strOutLow + c;
			}
		else { c = (char) (c + 32);	
		strOutLow = strOutLow + c;
		}
		i++;
		}

		return strOutLow;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code

		str = preProcess(str);
		
		char [] digits = str.toCharArray();
		int n = str.length();
        for (int i = 0; i < n; i++) {
            int randomIndex = (int) (Math.random() * n);
		char changed = digits [i];
		digits [i] = digits [randomIndex];
		digits [randomIndex] = changed;
		}
		String newString = new String (digits);
		return newString;
	}
}