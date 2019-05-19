package com.coding.practice.tree;

public class PrintAutoSuggestions extends Trie {

	public static int printAutoSuggestions(TrieNode root, String query) {
		TrieNode pCrawl = root;
		int level;
		int n = query.length();
		for (level = 0; level < n; level++) {
			int index = query.charAt(level) - 'a';
			if (pCrawl.children[index] == null) {
				return 0;
			}

			pCrawl = pCrawl.children[index];
		}

		// if prefix is present as word
		boolean isWord = (pCrawl.isEndOfWord == true);

		// if prefix is last node of tree has no children
		boolean isLast = TrieNode.isLastNode(pCrawl);

		// if prefix is present as word but there is no subtree below the last matching
		// node.
		if (isWord && isLast) {
			System.out.println(query);
			return -1;
		}

		// if there are nodes below the last point
		if (!isLast) {
			String prefix = query;
			suggestionRec(pCrawl, prefix);
			return 1;
		}
		return 0;
	}

	public static void suggestionRec(TrieNode root, String prefix) {
		// found string in trie with given prefix
		if (root.isEndOfWord) {
			System.out.println(prefix);
		}

		// all children pointers are null
		if (root.isLastNode(root)) {
			return;
		}

		String tobeUsed = prefix;
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if(TrieNode.isMultiChild(root)) {
				if (root.children[i] != null) {
					prefix = tobeUsed + Character.toString((char) (97+i));
					suggestionRec(root.children[i], prefix);
				}
			} else {
				if (root.children[i] != null) {
					prefix = prefix + Character.toString((char) (97+i));
					suggestionRec(root.children[i], prefix);
				}
			}
		}
	}

	public static void main(String[] args) {

		String keys[] = { "hello", "aog", "hel", "cat", "a", "hel", "help", "helps", "helping" };
		root = new TrieNode();

		// Construct trie
		for (int i = 0; i < keys.length; i++)
			insert(keys[i]);

		printAutoSuggestions(root, "h");
	}
}
