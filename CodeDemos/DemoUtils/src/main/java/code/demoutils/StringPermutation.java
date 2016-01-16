package code.demoutils;

import java.util.ArrayList;
import java.util.List;

class StringPermutation {

	private static final List<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		permutate("", "abcd");
	}
	
	public static void permutate(String perm, String word) {
		if(word == null) {
			System.out.println("Error");
		} else if (word.isEmpty()) {
			result.add(perm + word);
			System.out.println(perm + word);
		} else {
			for(int i = 0 ; i < word.length() ; i++) {
				permutate(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
			}
		}
	}

	public static List<String> getResult() {
		return result;
	}
}
