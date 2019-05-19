package src.java.practice.tree;

public class Trie {

	static int ALPHABET_SIZE = 26;

	static class TrieNode {
		TrieNode[] children = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++) {
				children[i] = null;
			}
		}
		
		static boolean isLastNode(TrieNode trie) {
			for(int i = 0; i < trie.children.length; i++) {
				if(trie.children[i] != null) {
					return false;
				}
			}
			return true;
		}
		
		static boolean isMultiChild(TrieNode trie) {
			int count = 0;
			for(int i = 0; i < trie.children.length; i++) {
				if(trie.children[i] != null) {
					count++;
					if(count > 1) {
						return true;
					}
				}
			}
			return false;
		}
	}

	static TrieNode root;

	// if not present, insert key into trie node and if key is prefix of trie node
	// then mark leaf node.
	static void insert(String key) {
		int level;
		int length = key.length();
		int index;

		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}

			pCrawl = pCrawl.children[index];
		}

		// mark last node as leaf.
		pCrawl.isEndOfWord = true;
	}

	static boolean search(String key) {
		int level;
		int length = key.length();
		int index;

		TrieNode pCrawl = root;

		for (level = 0; level < length; level++) {
			index = key.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				return false;
			}

			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	
	/*// Driver
	public static void main(String args[]) {
		// Input keys (use only 'a' through 'z' and lower case)
		//String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
		String keys[] = {"hello","dog","hell","cat","a","hel","help" ,"helps" ,"helping"  };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);

		// Search for different keys
		if (search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);

	}*/

}
