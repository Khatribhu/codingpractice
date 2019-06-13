import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* Problem Name is &&& Longest Word &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate. 1) Given a a string of letters and a dictionary,
 * the function longestWord should find the longest word or words in the
 * dictionary that can be made from the letters Input: letters = "oet",
 * dictionary = {"to","toe","toes"} Output: {"toe"} Only lowercase letters will
 * occur in the dictionary and the letters The length of letters will be between
 * 1 and 10 characters The solution should work well for a dictionary of over
 * 100,000 words 2) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main(). 3) Consider adding some additional tests in
 * doTestsPass(). 4) Implement the longestWord() method correctly. 5) If time
 * permits, introduce '?' which can represent any letter. "to?" could match to
 * "toe", "ton" etc
 */

class Dictionary {
	private String[] entries;

	public Dictionary(String[] entries) {
		this.entries = entries;
	}

	public boolean contains(String word) {
		return Arrays.asList(entries).contains(word);
	}
}

public class DictionarySolution {
	public static Set<String> longestWord(String letters, Dictionary dict) {
		Set<String> result = new HashSet<String>();
		if (dict.contains(letters)) {
			result.add(letters);
		}
		return result;
	}

	public static String generateWords(String letters) {

	}

	public static boolean doTestsPass() {
		Dictionary dict = new Dictionary(
				new String[] { "to", "toe", "toes", "doe", "dog", "god", "dogs", "book", "banana" });

		boolean result = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
		result = result && new HashSet<String>(Arrays.asList("toes", "dogs")).equals(longestWord("osetdg", dict));

		result = result
				&& new HashSet<String>(Arrays.asList("doe", "toe", "dog", "god")).equals(longestWord("oetdg", dict));
		result = result && new HashSet<String>(Arrays.asList("book")).equals(longestWord("obokt", dict));
		result = result && new HashSet<String>(Arrays.asList("banana")).equals(longestWord("nanabaook", dict));
		result = result && new HashSet<String>().equals(longestWord("aeiou", dict));
		result = result && new HashSet<String>().equals(longestWord("a", dict));

		return result;

	}

	/**
	 * Execution entry point.
	 */
	public static void main(String[] args) {
		if (doTestsPass()) {
			System.out.println("All tests pass");
		} else {
			System.err.println("There are test failures");
		}
	}
}
