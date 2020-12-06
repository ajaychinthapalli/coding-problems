package edu.ajay.coading.approach.normal;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Boolean.*;
import static java.lang.String.*;

public class WordTest extends TestCase {

  private Word wordObj;

  @Override
  protected void setUp() {
    wordObj = new Word();
  }

  @Test
  public void testReverseWord() {
    // ~ given:
    String employeeName = "AJAY";
    String expectedResult = "YAJA";
    // ~ when:
    String actualResult = wordObj.reverseWord(employeeName);
    // ~ then:
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testContainsOnlyDigits() {
    // ~ given:
    String employeeName = "123";
    // ~ when:
    Boolean actualResult = wordObj.containsOnlyDigits(employeeName);
    // ~ then:
    assertEquals(TRUE, actualResult);
  }

  @Test
  public void testContainsOnlyDigitsFalse() {
    // ~ given:
    String employeeName = "ajay";
    // ~ when:
    Boolean actualResult = wordObj.containsOnlyDigits(employeeName);
    // ~ then:
    assertEquals(FALSE, actualResult);
  }

  @Test
  public void testContainsOnlyDigitsUsingMatches() {
    // ~ given:
    String employeeName = "123";
    // ~ when:
    Boolean actualResult = wordObj.containsOnlyDigitsUsingMatches(employeeName);
    // ~ then:
    assertEquals(TRUE, actualResult);
  }

  @Test
  public void testContainsOnlyDigitsUsingMatchesFalse() {
    // ~ given:
    String employeeName = "ajay";
    // ~ when:
    Boolean actualResult = wordObj.containsOnlyDigitsUsingMatches(employeeName);
    // ~ then:
    assertEquals(FALSE, actualResult);
  }

	/*
	 * @Test public void testCountVowelsAndConsonants() { // ~ given: String
	 * employeeName = "chinthapalli"; Pair<Integer, Integer> expectedResult = new
	 * Pair<>(4, 8); // ~ when: Pair<Integer, Integer> actualResult =
	 * wordObj.countVowelsAndConsonants(employeeName); // ~ then:
	 * assertEquals(expectedResult, actualResult); }
	 */

  @Test
  public void testCountOccurrencesOfACertainCharacter() {
    // ~ given:
    String employeeName = "ajay";
    Character character = 'a';
    // ~ when:
    Integer actualResult = wordObj.countOccurrencesOfACertainCharacter(employeeName, character);
    // ~ then:
    assertEquals(valueOf(2), valueOf(actualResult));
  }

  @Test
  public void testCountOccurrencesOfACertainCharacterUsingCounter() {
    // ~ given:
    String employeeName = "ajay";
    Character character = 'a';
    // ~ when:
    Integer actualResult = wordObj.countOccurrencesOfACertainCharacterUsingCounter(employeeName, character);
    // ~ then:
    assertEquals(valueOf(2), valueOf(actualResult));
  }

  @Test
  public void testRemoveWhiteSpaces() {
    // ~ given:
    String employeeName = "Ajay Chinthapalli";
    String expectedResult = "AjayChinthapalli";
    // ~ when:
    String actualResult = wordObj.removeWhiteSpaces(employeeName);
    // ~ then:
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testJoinByDelimiter() {
    // ~ given:
    Character ch = ' ';
    String[] args = new String[]{"Ajay", "Chinthapalli"};
    String expectedResult = "Ajay Chinthapalli";
    // ~ when:
    String actualResult = wordObj.joinByDelimiter(ch, args);
    // ~ then:
    assertEquals(expectedResult, actualResult);
  }

  /**
   * Mathematical Formula: 𝑃(𝑛,𝑟) = 𝑛!/(𝑛−𝑟)!
   * Example: 𝑃(𝑛,𝑟) = 𝑃(3,3) = 3!/(3-3)! = 3*2*1/1 = 6
   */
  @Test
  public void testPermuteAndPrintWithThreeLetters() {
    String employeeName = "ABC";
    // Total number of outcomes: 6
    wordObj.permuteAndPrint(employeeName);
  }

  /**
   * Mathematical Formula: 𝑃(𝑛,𝑟) = 𝑛!/(𝑛−𝑟)!
   * Example: 𝑃(𝑛,𝑟) = 𝑃(4,4) = 4!/(4-4)! = 4*3*2*1/1 = 24
   */
  @Test
  public void testPermuteAndPrintWithFourLetters() {
    String employeeName = "AJAY";
    // Total number of outcomes: 24
    wordObj.permuteAndPrint(employeeName);
  }

  @Test
  public void testPermuteAndStore() {
    // ~ given:
    String employeeName = "ABC";
    Set<String> expectedPermutations = new HashSet<>();
    expectedPermutations.add("ACB");
    expectedPermutations.add("BCA");
    expectedPermutations.add("ABC");
    expectedPermutations.add("CBA");
    expectedPermutations.add("BAC");
    expectedPermutations.add("CAB");
    // ~ when:
    Set<String> actualPermutations = wordObj.permuteAndStore(employeeName);
    // ~ then:
    assertEquals(expectedPermutations, actualPermutations);
  }

  @Override
  protected void tearDown() {
    wordObj = null;
  }
}
