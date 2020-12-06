package edu.ajay.coading.approach.streams;

import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import static edu.ajay.coading.approach.util.AppConstants.*;
import static java.lang.Boolean.*;
import static java.lang.Character.*;
import static java.lang.String.*;
import static java.util.Arrays.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;

/**
 *
 * @author  Ajay Chinthapalli
 * @version 1.0
 * @since   2020-10-28
 */
public class Word {

  /**
   * Reverses the given word using java streams.
   *
   * @param employeeName
   * @return String
   */
  protected String reverseWordUsingStreams(String employeeName) {
    return PATTERN.splitAsStream(employeeName)
      .map(word -> new StringBuilder(word).reverse())
      .collect(joining(WHITESPACE));
  }

  /**
   * Checking whether a string contains only digits.
   *
   * @param employeeName
   * @return true/false
   */
  protected Boolean containsOnlyDigits(String employeeName) {
    // Notice that Java 8 functional style and regular expression-based solutions are usually slow,
    // so if performance is a requirement, then it's better to rely on the Character.isDigit() approach.

    // Avoid solving this problem using parseInt() or parseLong().
    // First of all, It's bad practice to catch NumberFormatException and take business logic decisions in the catch block.
    // Second, these methods verify whether the string is a valid number, not whether it contains only digits( for example -4 is valid).
    // For third-party library support, please consider the Apache Commons Lang, StringUtils.isNumeric().

    // In Java 8 functional style, the normal style Character.isDigit() code can be rewritten using anyMatch()
    return employeeName
      .chars()
      .anyMatch(digit -> isDigit(digit));
  }

  /**
   * Counting vowels and consonants.
   * In Java 8 functional style, the code can be written using chars() and filter()
   *
   * @param employeeName
   * @return Pair
   */
	/*
	 * protected Pair<Long, Long> countVowelsAndConsonants(String employeeName) { //
	 * Initially, the given employeeName is transformed into lowercase. This is
	 * useful to avoid // comparisons with uppercase characters. For example, the
	 * comparison is accomplished only // against 'a' instead of 'A'. employeeName =
	 * employeeName.toLowerCase();
	 * 
	 * Long vowels = employeeName .chars() .filter(character ->
	 * allVowels.contains((char) character)) .count(); Long consonants =
	 * employeeName .chars() .filter(c -> !allVowels.contains((char) c)) .filter(ch
	 * -> (ch >= 'a' && ch <= 'z')) .count(); return new Pair<Long, Long>(vowels,
	 * consonants); }
	 */

  /**
   * Counting vowels and consonants.
   * The given string employeeName is filtered accordingly and the count() terminal operation returns the result.
   * Relying on partitioningBy() will reduce the code.
   *
   * @param employeeName
   * @return Pair
   */
	/*
	 * protected Pair<Long, Long> countVowelsAndConsonantsUsingPartitioningBy(String
	 * employeeName) { // Initially, the given employeeName is transformed into
	 * lowercase. This is useful to avoid // comparisons with uppercase characters.
	 * For example, the comparison is accomplished only // against 'a' instead of
	 * 'A'. employeeName = employeeName.toLowerCase(); Map<Boolean, Long> result =
	 * employeeName .chars() .mapToObj(ch -> (char) ch) .collect(partitioningBy(c ->
	 * allVowels.contains(c), counting ()));
	 * 
	 * return new Pair<Long, Long>(result.get(TRUE), result.get(FALSE)); }
	 */

  /**
   * Counting the occurrences of a certain character.
   * In Java 8 functional style, the code can be written using chars() and filter().
   *
   * Other ways to implement this using third-party library support:
   * -> Apache Commons Lang: StringUtils.countMatches()
   * -> Spring Framework: StringUtils.countOccurrencesOf()
   * -> Guava: CharMatcher.is().countIn()
   *
   * @param employeeName
   * @param character
   * @return Integer
   */
  protected Integer countOccurrencesOfACertainCharacter(String employeeName, Character character) {
    Long occurrencesCount = employeeName
      .chars()
      .filter(ch -> ch == character)
      .count();
    return occurrencesCount.intValue();
  }

  /**
   * Joining multiple strings with a delimiter.
   * In Java 8, one of the solution relies on the StringJoiner. It supports an optional prefix and suffix as well (ignored here)
   *
   * @param delimiter
   * @param args
   * @return String
   */
  protected String joinByDelimiterUsingStringJoiner(Character delimiter, String... args) {
    StringJoiner joiner = new StringJoiner( valueOf(delimiter));
    for (String arg : args) {
      joiner.add(arg);
    }
    return joiner.toString();
  }

  /**
   * Joining multiple strings with a delimiter.
   * Another solution relies on the String.join() method. This method was introduced
   * in Java 8 comes in two flavours.
   * -> String join(CharSequence delimiter, CharSequence... elems)
   * -> String join(CharSequence delimiter, Iterable</? extends CharSequence> elems)
   *
   * @param delimiter
   * @param firstName
   * @param lastName
   * @return String
   */
  protected String joinByDelimiterUsingJoin(String delimiter, String firstName,
                                            String lastName) {
    return join(delimiter, firstName, lastName);
  }

  /**
   * Joining multiple strings with a delimiter.
   * Another solution relies on streams and  Collectors.joining()
   *
   * For third-party library support, please consider
   * -> Apache Commons Lang: StringUtils.join()
   * -> Guava: Joiner
   *
   * @param delimiter
   * @param args
   * @return String
   */
  protected String joinByDelimiterUsingStreams(Character delimiter, String... args) {
    return stream(args, START_INCLUSIVE, args.length)
      .collect(joining(valueOf(delimiter)));
  }

  /**
   * Generating all permutations.
   *
   * @param employeeName
   */
  protected void permuteAndPrintStream(String employeeName) {
    // Initially, the prefix should be an empty string, "". At each iteration, the prefix will
    // concatenate (fix) the next letter from the string. The remaining letters are passed
    // through the method again.
    permuteAndPrintStream("", employeeName);
  }

  /**
   *
   * @param prefix
   * @param employeeName
   */
  protected void permuteAndPrintStream(String prefix, String employeeName) {
    Integer length = employeeName.length();
    if (length == 0) {
      System.out.println(prefix + " ");
    } else {
      IntStream.range(0, length)
        .parallel()
        .forEach(index -> permuteAndPrintStream(prefix + employeeName.charAt(index),
          employeeName.substring(index+1, length) + employeeName.substring(0, index)));
    }
  }
}
