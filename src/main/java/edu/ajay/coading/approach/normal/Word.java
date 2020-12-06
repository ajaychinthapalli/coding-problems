package edu.ajay.coading.approach.normal;

import java.util.HashSet;
import java.util.Set;

import static edu.ajay.coading.approach.util.AppConstants.*;
import static java.lang.Boolean.*;
import static java.lang.Character.*;

/**
 *
 * @author  Ajay Chinthapalli
 * @version 1.0
 * @since   2020-10-28
 */
public class Word {

  /**
   * Reverses the given word.
   *
   * @param employeeName
   * @return String
   */
  protected String reverseWord(String employeeName) {
    StringBuilder reversedWord = new StringBuilder();

    // Splitting the employeeName into an array of words using a white space as the delimiter
    String[] words = employeeName.split(WHITESPACE);

    for (String word : words) {
      StringBuilder reverseWord = new StringBuilder();
      for(Integer index = word.length()-1; index >= 0; index--) {
        reverseWord.append(word.charAt(index));
      }
      reversedWord.append(reverseWord);
    }
    return reversedWord.toString();
  }

  /**
   * Checking whether a string contains only digits.
   *
   * @param employeeName
   * @return true/false
   */
  protected Boolean containsOnlyDigits(String employeeName) {
    for (Integer index = 0; index < employeeName.length() ; index++) {
      if (isDigit(employeeName.charAt(index))) {
        return TRUE;
      }
    }
    return FALSE;
  }

  /**
   * Checking whether a string contains only digits using String.matches().
   *
   * @param employeeName
   * @return true/false
   */
  protected Boolean containsOnlyDigitsUsingMatches(String employeeName) {
    return employeeName.matches("[0-9]+");
  }

  /**
   * Counting vowels and consonants.
   * The solution of this problem requires traversing the string characters and doing the following.
   * -> We need to check whether current character is a vowel(a, e, i, o, u).
   * -> If the current character is not a vowel, then check whether it sits between 'a' and 'z'
   * this means that the current character is a consonant.
   *
   *
   * @param employeeName
   * @return Pair
   */
	/*
	 * protected Pair<Integer, Integer> countVowelsAndConsonants(String
	 * employeeName) { Integer vowels = 0; Integer consonants = 0; // Initially, the
	 * given employeeName is transformed into lowercase. This is useful to avoid //
	 * comparisons with uppercase characters. For example, the comparison is
	 * accomplished only // against 'a' instead of 'A'. employeeName =
	 * employeeName.toLowerCase(); Set<Character> allVowels = new
	 * HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')); for (Integer index = 0;
	 * index < employeeName.length(); index++) { Character character =
	 * employeeName.charAt(index); if (allVowels.contains(character)) { vowels++; }
	 * else if((character >= 'a' && character <= 'z')) { consonants++; } } return
	 * new Pair<Integer, Integer>(vowels, consonants); }
	 */

  /**
   * Counting the occurrences of a certain character.
   * The solution of this problem consists of the following below steps.
   * -> Replace every occurrence of the character in the given string with "". Basically,
   * this is like removing all of the occurrences of this character in the given string.
   * -> Subtract the length of the string that was obtained in the first step from the
   * length of the initial string.
   *
   *
   * @param employeeName
   * @param character
   * @return Integer
   */
  protected Integer countOccurrencesOfACertainCharacter(String employeeName, Character character) {
    return employeeName.length() - employeeName.replace(String.valueOf(character), "")
      .length();
  }

  /**
   * Counting the occurrences of a certain character.
   * The solution of this problem is easy to implement and fast solution consists of looping
   * the string characters (a single traversal) and comparing each character with the given
   * character. Increase the counter by one for every match.
   *
   *
   * @param employeeName
   * @param character
   * @return Integer
   */
  protected Integer countOccurrencesOfACertainCharacterUsingCounter(String employeeName, Character character) {
    Integer count = 0;
    for (int index = 0; index < employeeName.length(); index++) {
      if (employeeName.charAt(index) == character) {
        count++;
      }
    }
    return count;
  }

  //Converting a string into an int, long, float or double
  /**
   * Let's consider the following strings(negatives can be used as well):
   * private static final String TO_INT = "453";
   * private static final String TO_LONG = "45234223233";
   * private static final String TO_FLOAT = "45.823F";
   * private static final String TO_DOUBLE = "12.83423D";
   *
   * A proper solution for converting String into int, long, float or double consists
   * of using the following Java methods of the Integer, Long, Float and Double
   * classes -> parseInt(), parseLong(), parseFloat(), parseDouble():
   *
   * int toInt = Integer.parseInt(TO_INT);
   * long toLong = Long.parseLong(TO_LONG);
   * float toFloat = Float.parseFloat(TO_FLOAT);
   * double toDouble = Double.parseDouble(TO_DOUBLE);
   *
   * Converting String into an Integer, Long, Float or Double object can be accomplished
   * via the following Java methods -> Integer.valueOf(), Long.valueOf(), Float.valueOf(),
   * Double.valueOf():
   *
   * Integer toInt = Integer.valueOf(TO_INT);
   * Long toLong = Long.valueOf(TO_LONG);
   * Float toFloat = Float.valueOf(TO_FLOAT);
   * Double toDouble = Double.valueOf(TO_DOUBLE);
   *
   * Note: For third-party library support
   * Apache Commons BeanUtils: IntegerConverter, LongConverter, FloatConverter and DoubleConverter.
   */

  /**
   * Removing white spaces from a string.
   * The solution to this problem consists of using the String.replaceAll() method
   * with the \s regular expression. Mainly, \s removes all white spaces, including
   * the non-visible ones, such as \t, \n and \r
   *
   * Starting with JDK11, String.isBlank() checks whether the string is empty or
   * contains only whitespace code points. For third-party library support, consider
   * Apache Commons Lang, StringUtils.deleteWhitespace(), and  the Spring Framework,
   * StringUtils.trimAllWhitespace().
   *
   * @param employeeName
   * @return String
   */
  protected String removeWhiteSpaces(String employeeName) {
    return employeeName.replaceAll("\\s", "");
  }

  /**
   * Joining multiple strings with a delimiter.
   * There are several solutions that fit well and solve this problem. Before Java 8, a
   * convenient approach relied on StringBuilder.
   *
   * @param delimiter
   * @param args
   * @return String
   */
  protected String joinByDelimiter(Character delimiter, String... args) {
    StringBuilder result =new StringBuilder();
    Integer index;
    for (index = 0; index < args.length-1; index++) {
      result.append(args[index]).append(delimiter);
    }
    result.append(args[index]);
    return result.toString();
  }

  /**
   * Generating all permutations.
   * Problems that involve permutations commonly involve recursivity as well. Basically,
   * recursivity is defined as a process where some initial state is given and each successive
   * state is defined in terms of the preceding state.
   *
   * In this scenario, the state can be materialized by the letters of the given string. The initial
   * state contains the initial string and each successive state can be computed by this formula:
   * each letter of the string will become the first letter of the string (swap positions) and then
   * permute all of the remaining letters using a recursive call. While non-recursive or other
   * recursive solutions exist, this is a classical solution to this problem.
   *
   * Mathematical Formula: 𝑃(𝑛,𝑟) = 𝑛!/(𝑛−𝑟)!
   * Example: 𝑃(𝑛,𝑟) = 𝑃(3,3) = 3!/(3-3)! = 3*2*1/1 = 6
   *
   * @param employeeName
   */
  protected void permuteAndPrint(String employeeName) {
    // Initially, the prefix should be an empty string, "". At each iteration, the prefix will
    // concatenate (fix) the next letter from the string. The remaining letters are passed
    // through the method again.
    permuteAndPrint("", employeeName);
  }

  /**
   *
   * @param prefix
   * @param employeeName
   */
  protected void permuteAndPrint(String prefix, String employeeName) {
    Integer length = employeeName.length();
    if (length == 0) {
      System.out.println(prefix + " ");
    } else {
      for (int index = 0; index < length; index++) {
        permuteAndPrint(prefix + employeeName.charAt(index),
          employeeName.substring(index+1, length) + employeeName.substring(0, index));
      }
    }
  }

  /**
   * Generating all permutations.
   *
   * @param employeeName
   * @return Set
   */
  protected Set<String> permuteAndStore(String employeeName) {
    // Initially, the prefix should be an empty string, "". At each iteration, the prefix will
    // concatenate (fix) the next letter from the string. The remaining letters are passed
    // through the method again.
    return permuteAndStore("", employeeName);
  }

  /**
   * Notice that this solution prints the result on the screen. Storing the result implies
   * adding Set to the implementation. It is preferable to use Set since it  eliminates
   * duplicates.
   *
   * @param prefix
   * @param employeeName
   * @return Set
   */
  protected Set<String> permuteAndStore(String prefix, String employeeName) {
    Set<String> permutations = new HashSet<>();
    Integer length = employeeName.length();
    if (length == 0) {
      permutations.add(prefix);
    } else {
      for (int index = 0; index < length; index++) {
        permutations.addAll(permuteAndStore(prefix + employeeName.charAt(index),
          employeeName.substring(index+1, length) + employeeName.substring(0, index)));
      }
    }
    return permutations;
  }
}
