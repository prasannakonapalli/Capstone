import java.util.*;

public class PigLatin {

	public static void main(String[] args) {
		System.out.println("Welcome to the Pig Latin Translator!");
		System.out.println();
		translateString();

	}

	public static void translateString() {
		String startString = "";
		String endString = "";
		String res = "";
		int length = 0;
		String output = "";
		String sentence = "";
		String con = "";

		try {
			Scanner scr = new Scanner(System.in);

			do {
				System.out.println("Enter a line to be translated:");

				sentence = scr.next();
				sentence = sentence + scr.nextLine();
				if (sentence.equals("")) {
					throw new Exception();
				}

				// do word translations
				String[] words = sentence.split(" ");
				String word = "";

				for (int i = 0; i < words.length; i++) {

					word = words[i];
					length = word.length();
					String wordLowercase = word.toLowerCase();

					if (validateSpecialChars(wordLowercase)) {
						res = word;
						output += res + " ";
					} else if (wordLowercase.startsWith("a") || wordLowercase.startsWith("e")
							|| wordLowercase.startsWith("i") || wordLowercase.startsWith("o")
							|| wordLowercase.startsWith("u")) {// do vowels starts with check
						word = word + "way";
						output += word + " ";
					} else {// do consonants starts with check

						for (int z = 0; z < wordLowercase.length(); z++) {

							if (wordLowercase.charAt(z) == 'a' || (wordLowercase.charAt(z) == 'e')
									|| (wordLowercase.charAt(z) == 'i') || (wordLowercase.charAt(z) == 'o')
									|| (wordLowercase.charAt(z) == 'u')) {

								int vowelIdx = word.indexOf(word.charAt(z));
								startString = word.substring(vowelIdx, length);
								endString = word.substring(0, vowelIdx);
								res = startString + endString + "ay";
								break;
							} else {
								res = word;
							}

						}

						output += res + " ";

					}
				}
				System.out.print(output + " ");
				System.out.println();
				System.out.print("Translate another line? (y/n):");
				con = scr.next();

				// validate to continue
				if (con.equalsIgnoreCase("y")) {
					translateString();
				} else if (con.equalsIgnoreCase("n")) {
					System.exit(0);
				} else {
					throw new Exception();
				}
			} while (con.equalsIgnoreCase("y") || con.equalsIgnoreCase("n"));

			scr.close();

		} catch (Exception e) {
			System.out.println("********************************");
			System.out.println("Invalid input");
			System.out.println(e);
			System.exit(0);
		}

	}

	public static boolean validateSpecialChars(String wordLowercase) {
		for (int i = 0; i < wordLowercase.length(); i++) {

			if ((wordLowercase.charAt(i) >= 48 && wordLowercase.charAt(i) <= 57)
					|| (wordLowercase.charAt(i) >= 32 && wordLowercase.charAt(i) <= 47 && wordLowercase.charAt(i) != 39)
					|| (wordLowercase.charAt(i) >= 58 && wordLowercase.charAt(i) <= 64)
					|| (wordLowercase.charAt(i) >= 91 && wordLowercase.charAt(i) <= 96)
					|| (wordLowercase.charAt(i) > 122)) {
				return true;
			}
		}
		return false;
	}

}
