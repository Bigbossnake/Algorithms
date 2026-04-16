/**
 * 1. General rule: take the first letter of a word, move it to the end, and add "ay". Example:
 * "hello" becomes "ellohay".
 *
 * <p>2. A phrase with multiple words should translate each word: "hello world" becomes "ellohay
 * orldway"
 *
 * <p>3. A word which begins with a vowel keeps its first letter, and just adds "way" to the end of
 * the word: "eat apples" becomes "eatway applesway"
 *
 * <p>4. A word which is capitalized should remain capitalized after translation: "Hello world"
 * becomes "Ellohay orldway"
 */
package company.helix;

import java.util.Set;

public class PigLatin {
  private static final Set<Character> VOWELS =
      Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

  public String createPigLatinWord(String input) {
    int start              = 1;
    int end                = input.length();
    char firstLetter       = input.charAt(0);
    String latinWordPrefix = "ay";

    // Contains Vowels
    if (VOWELS.contains(firstLetter)) {
      start = 0;
      latinWordPrefix = "way";
    }

    StringBuilder pigLatinWord = new StringBuilder(input.substring(start, end));

    // Don't need to include the first letter at the end if it's a vowel
    if (!VOWELS.contains(firstLetter)) {
      pigLatinWord.append(Character.toLowerCase(firstLetter));
    }

    pigLatinWord.append(latinWordPrefix);

    if (Character.isUpperCase(firstLetter)) {
      char firstUpperCaseLetter = Character.toUpperCase(pigLatinWord.charAt(0));
      pigLatinWord.setCharAt(0, firstUpperCaseLetter);
    }

    return pigLatinWord.toString();
  }

  public String transformSentence(String sentence) {
    String spaceToken = " ";
    StringBuilder pigLatinSentence = new StringBuilder();
    String[] words = sentence.trim().split(spaceToken);

    for (String word : words) {
      String pigLatinWord = createPigLatinWord(word);
      pigLatinSentence.append(pigLatinWord);
      pigLatinSentence.append(spaceToken);
    }

    return pigLatinSentence.toString().trim();
  }

  public static void main(String[] args) {
    PigLatin pigLatin = new PigLatin();
    String input1 = "hello";
    String input2 = "hello world";
    String input3 = "eat apples";
    String input4 = "Hello world";

    System.out.println(
        "Pig Latin for '"
            + input1
            + "': "
            + pigLatin.transformSentence(input1)
            + " Answer: 'ellohay'");
    System.out.println(
        "Pig Latin for '"
            + input2
            + "': "
            + pigLatin.transformSentence(input2)
            + " Answer: 'ellohay orldway'");
    System.out.println(
        "Pig Latin for '"
            + input3
            + "': "
            + pigLatin.transformSentence(input3)
            + " Answer: 'eatway applesway'");
    System.out.println(
        "Pig Latin for '"
            + input4
            + "': "
            + pigLatin.transformSentence(input4)
            + " Answer: 'Ellohay orldway'");
  }
}
