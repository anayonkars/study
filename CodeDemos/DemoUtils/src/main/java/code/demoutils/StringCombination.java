package code.demoutils;

import java.util.ArrayList;
import java.util.List;

class StringCombination {

	private static final List<String> result = new ArrayList<>();
	
	public static void main(String[] args) {
		combine("abcd", new StringBuilder(), 0);
	}
	
	public static void combine(String input, StringBuilder output, int index) {
		for(int i = index ; i < input.length() ; i++) {
			output.append(input.charAt(i));
			System.out.println(output);
			result.add(output.toString());
			combine(input, output, i + 1);
			output.deleteCharAt(output.length() - 1);
		}
	}

	public static List<String> getResult() {
		return result;
	}
}
