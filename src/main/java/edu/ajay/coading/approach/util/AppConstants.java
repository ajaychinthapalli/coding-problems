package edu.ajay.coading.approach.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static java.util.regex.Pattern.compile;

/**
 *
 * @author  Ajay Chinthapalli
 * @version 1.0
 * @since   2020-10-29
 */
public class AppConstants {
  public static final String WHITESPACE = " ";
  public static final Pattern PATTERN = compile(" +");
  public static final Integer START_INCLUSIVE = 0;
  public static final Set<Character> allVowels = new HashSet<> (asList('a', 'e', 'i', 'o', 'u'));
}
