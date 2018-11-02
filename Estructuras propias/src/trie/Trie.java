package trie;

import java.util.HashMap;

public class Trie {
	public Trie[] letters;
//HashMap<Character, Integer>map= new HashMap<>();

	public Trie() {
		super();
		this.letters = new Trie[26];
	}

	public void add(char l) {
		int index = (int) (l - 'a');
		if (letters[index] == null) {
			letters[index] = new Trie();
		}
	}

	public void add(String s) {
		if (s == null || s.isEmpty()) {

		} else {
			int index = (int) (s.charAt(0) - 'a');
			if (letters[index] == null) {
				letters[index] = new Trie();

			}

				letters[index].add(s.substring(1));
			}
		}
	public int size() {
		return letters.length;
	}
	}

