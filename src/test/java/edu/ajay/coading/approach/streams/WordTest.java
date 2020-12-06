package edu.ajay.coading.approach.streams;

import junit.framework.TestCase;
import org.junit.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.String.valueOf;

public class WordTest extends TestCase {

  private Word wordObj;

  @Override
  protected void setUp() {
    wordObj = new Word();
  }

  @Test
  public void testReverseWordUsingStreams() {
    // ~ given:
    String employeeName = "ajay";
    String expectedResult = "yaja";
    // ~ when:
    String actualResult = wordObj.reverseWordUsingStreams(employeeName);
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

	/*
	 * @Test public void testCountVowelsAndConsonants() { // ~ given: String
	 * employeeName = "chinthapalli"; Pair<Long, Long> expectedResult = new
	 * Pair<>(4L, 8L); // ~ when: Pair<Long, Long> actualResult =
	 * wordObj.countVowelsAndConsonants(employeeName); // ~ then:
	 * assertEquals(expectedResult, actualResult); }
	 */

	/*
	 * @Test public void testCountVowelsAndConsonantsUsingPartitioningBy() { // ~
	 * given: String employeeName = "ajay"; Pair<Long, Long> expectedResult = new
	 * Pair<>(2L, 2L); // ~ when: Pair<Long, Long> actualResult =
	 * wordObj.countVowelsAndConsonantsUsingPartitioningBy(employeeName); // ~ then:
	 * assertEquals(expectedResult, actualResult); }
	 */

  @Test
  public void testCountOccurrencesOfACertainCharacter() {
    // ~ given:
    String employeeName = "ajay chinthapalli";
    Character character = 'a';
    // ~ when:
    Integer actualResult = wordObj.countOccurrencesOfACertainCharacter(employeeName, character);
    // ~ then:
    assertEquals(valueOf(4), valueOf(actualResult));
  }

  @Test
  public void testJoinByDelimiterUsingStringJoiner() {
    // ~ given:
    Character ch = ' ';
    String[] args = new String[]{"Ajay", "Chinthapalli"};
    String expectedResult = "Ajay Chinthapalli";
    // ~ when:
    String actualResult = wordObj.joinByDelimiterUsingStringJoiner(ch, args);
    // ~ then:
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testJoinByDelimiterUsingJoin() {
    // ~ given:
    String delimiter = " ";
    String firstName = "Ajay";
    String lastName = "Chinthapalli";
    String expectedResult = "Ajay Chinthapalli";
    // ~ when:
    String actualResult = wordObj.joinByDelimiterUsingJoin(delimiter, firstName, lastName);
    // ~ then:
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testJoinByDelimiterUsingStreams() {
    // ~ given:
    Character ch = ' ';
    String[] args = new String[]{"Ajay", "Chinthapalli"};
    String expectedResult = "Ajay Chinthapalli";
    // ~ when:
    String actualResult = wordObj.joinByDelimiterUsingStreams(ch, args);
    // ~ then:
    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testPermuteAndPrintStream() {
    String employeeName = "ABC";
    // Total number of outcomes: 6
    wordObj.permuteAndPrintStream(employeeName);
  }

  @Override
  protected void tearDown() {
    wordObj = null;
  }
}
