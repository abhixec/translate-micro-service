package com.abhinav.example.translate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PigTranslate implements ITranslate {

	public String translate(String input) {
		if(input == null) return "string is empty";
		String[] words = input.split("\\s+");
		List<String> result = new ArrayList<>();
		Arrays.asList(words).stream().forEach(word ->{
			if(isVowel(word.charAt(0))){
				result.add(stringWithVowel(word));
			}
			else{
				result.add(stringWithOutVowel(word));
			}
		});
		return String.join(" ", result);
	}

	private static String stringWithOutVowel(String word) {

		StringBuilder finalString = new StringBuilder();
		int indexOfFirstVowel = firstVowelInString(word);
		String start = word.substring(0, indexOfFirstVowel);
		String restOfWord = word.substring(indexOfFirstVowel);
		String endString = "ay";
		int lengthOfWord = restOfWord.length();

		if (restOfWord.substring(lengthOfWord - 1, lengthOfWord).matches("[^a-zA-Z0-9 ]")) {
			String endingCharacter = restOfWord.substring(lengthOfWord - 1, lengthOfWord);
			finalString.append(restOfWord.substring(0, lengthOfWord - 1));
			finalString.append(start);
			finalString.append(endString);
			finalString.append(endingCharacter);
		} else {
			finalString.append(restOfWord);
			finalString.append(start);
			finalString.append(endString);
		}
		return finalString.toString();
	}

	private static String stringWithVowel(String word) {
		int lengthOfWord = word.length();
		StringBuilder finalString = new StringBuilder();
//		System.out.println(word.substring(lengthOfWord - 1, lengthOfWord));
		if (word.substring(lengthOfWord - 1, lengthOfWord).matches("[^a-zA-Z0-9 ]")) {
			String endingCharacter = word.substring(lengthOfWord - 1, lengthOfWord);
			finalString.append(word.substring(0, lengthOfWord - 1));
			finalString.append("yay");
			finalString.append(endingCharacter);

		} else {
			finalString.append(word);
			finalString.append("yay");
		}
		return finalString.toString();
	}

	private static boolean isVowel(char c) {
		return "AEIOUaeiou".indexOf(c) != -1;
	}

	private static int firstVowelInString(String input) {
		String vowels = "aeiou";
		input = input.toLowerCase();
		int index = 0;
		for (int i = 0; i < input.length(); i++) {
			if (vowels.contains(String.valueOf(input.charAt(i)))) {
				return i;
			}
		}
		return -1;
	}
}
