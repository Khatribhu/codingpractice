package src.java.practice.sorting;

public class FindAllSubStrings {

	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// a suffix trie node
	static class SuffixTrieNode {
		static final int MAX_CHAR = 26;

		SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
		Character val;

		public SuffixTrieNode() {
			// initialize all children with null
			for (int i = 0; i < children.length; i++) {
				children[i] = null;
				val = '0';
			}
		}

		// recursive method to insert a suffix of the s in subtree rooted with this
		// node.
		void insertSuffix(String str) {
			// if string has more character
			if (str.length() > 0) {

				// find first char and convert into 0-25 range
				int cIndex = (str.charAt(0) - 'a');

				// if no edge for this character add one edge.
				if (children[cIndex] == null) {
					children[cIndex] = new SuffixTrieNode();
					children[cIndex].val = str.charAt(0);
				}

				// recur for the next suffix
				children[cIndex].insertSuffix(str.substring(1));
			}
		}
	}

	// A trie for all suffixes.
	static class Suffix_Trie {
		static final int MAX_CHAR = 26;
		static SuffixTrieNode root;

		// constructor build a trie of suffixes of given text.
		public Suffix_Trie(String s) {
			root = new SuffixTrieNode();

			// consider all suffixes on given string and insert them into the suffix trie
			// using recursive function insertSuffix()
			for (int i = 0; i < s.length(); i++) {
				root.insertSuffix(s.substring(i));
			}
		}

		// recursive function to count nodes in trie.
		public int _countNodesAndStringInTrie(SuffixTrieNode node, StringBuilder stringBuilder) {
			// all nodes for this combination has been processed.
			if (node == null) {
				return 0;
			}
			int count = 0;
			for (int i = 0; i < MAX_CHAR; i++) {
				// if children is not null then find the count of all nodes in this subtrie.
				if (node.children[i] != null && node.children[i].val != '0') {
					count += _countNodesAndStringInTrie(node.children[i], stringBuilder.append(node.children[i].val));
				}
				System.out.println(stringBuilder.toString());
			}

			// return count of nodes of subtrie and plus one for its own count.
			return count + 1;
		}

		public int countNodesInTrie() {
			StringBuilder stringBuilder = new StringBuilder();
			return _countNodesAndStringInTrie(root, stringBuilder);
		}

	}

	/**
	 * Idea is to create a Trie of all suffixes of given string. once trie is
	 * constructed, our answer if number of nodes constructed in Trie.
	 * 
	 * @param input
	 */
	public static int countDistinctSubArray(String input) {
		// construct trie for all subarray
		Suffix_Trie suffix_Trie = new Suffix_Trie(input);

		return suffix_Trie.countNodesInTrie();
	}

	public static void main(String[] args) {
		String str = "khatri";
		System.out.println("count of distinct substrings: " + countDistinctSubArray(str));
	}
}
