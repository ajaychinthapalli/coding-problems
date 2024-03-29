package edu.ajay.coading.approach.practice;

import java.io.IOException;
import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import edu.ajay.coading.approach.practice.Book.Topic;
import junit.framework.TestCase;

import static com.google.common.io.Resources.*;
import static java.util.Arrays.*;

public class BookTest extends TestCase {

	private static final String LIST_OF_BOOKS = "fixtures/list-of-books.txt";
	private static final String BOOKS_BY_TOPIC = "fixtures/books-by-topic.txt";
	private static final String TITLE_TO_PUBLICATION_DATE = "fixtures/title-to-publication-date.txt";
	private static final String PROGRAMMING_OR_HISTORY = "fixtures/programming-or-history.txt";
	private static final String MOST_AUTHORS_BY_TOPIC = "fixtures/most-authors-by-topic.txt";
	private static final String VOLUME_COUNT_BY_TOPIC = "fixtures/volume-count-by-topic.txt";
	private static final String MOST_POPULAR_TOPIC = "fixtures/most-popular-topic.txt";
	private static final String CONCATENATED_TITLES_BY_TOPIC = "fixtures/concatenated-titles-by-topic.txt";
	private static final String AUTHORS_FOR_BOOKS = "fixtures/authors-for-books.txt";

	private Book book;
	private Book java, database, wingsOfFire, middleware;
	private List<Book> library;

	@Override
	protected void setUp() {
		book = new Book();
		java = new Book("Fundamentals of Java Programming", asList("Ajay", "Sathiesh"), new int[] { 100 },
				Topic.PROGRAMMING, Year.of(2020), 25.2);
		database = new Book("Fundamentals of Database", asList("Vasu"), new int[] { 200 }, Topic.PROGRAMMING,
				Year.of(2012), 30.4);
		wingsOfFire = new Book("Wings Of Fire", asList("Ravi"), new int[] { 146 }, Topic.HISTORY, Year.of(2017),
				18.6);
		middleware = new Book("Fundamentals of Middleware", asList("Raj Kumar"), new int[] { 237 },
				Topic.PROGRAMMING, Year.of(2018), 22.6);

		library = asList(java, database, wingsOfFire, middleware);
	}

	@Test
	public void testGetListOfBooks() throws IOException {
		// ~ when:
		List<Book> actualResult = book.getListOfBooks(library);
		// ~ then:
		Assert.assertEquals(readResource(LIST_OF_BOOKS).toString(), actualResult.toString());
	}

	@Test
	public void testGetBooksByTopic() throws IOException {
		// ~ when:
		Map<Topic, List<Book>> actualResult = book.getBooksByTopic(library);
		// ~ then:
		Assert.assertEquals(readResource(BOOKS_BY_TOPIC).toString(), actualResult.toString());
	}

	@Test
	public void testGetTitleToPublicationDate() throws IOException {
		// ~ when:
		Map<String, Year> actualResult = book.getTitleToPublicationDate(library);
		// ~ then:
		Assert.assertEquals(readResource(TITLE_TO_PUBLICATION_DATE).toString(), actualResult.toString());
	}

	@Test
	public void testIsProgrammingOrHistory() throws IOException {
		// ~ when:
		Map<Boolean, List<Book>> actualResult = book.isProgrammingOrHistory(library);
		// ~ then:
		Assert.assertEquals(readResource(PROGRAMMING_OR_HISTORY).toString(), actualResult.toString());
	}

	@Test
	public void testGetMostAuthorsByTopic() throws IOException {
		// ~ when:
		Map<Topic, Optional<Book>> actualResult = book.getMostAuthorsByTopic(library);
		// ~ then:
		Assert.assertEquals(readResource(MOST_AUTHORS_BY_TOPIC).toString(), actualResult.toString());
	}

	@Test
	public void testGetVolumeCountByTopic() throws IOException {
		// ~ when:
		Map<Topic, Integer> actualResult = book.getVolumeCountByTopic(library);
		// ~ then:
		Assert.assertEquals(readResource(VOLUME_COUNT_BY_TOPIC).toString(), actualResult.toString());
	}

	@Test
	public void testGetMostPopularTopic() throws IOException {
		// ~ when:
		Optional<Topic> actualResult = book.getMostPopularTopic(library);
		// ~ then:
		Assert.assertEquals(readResource(MOST_POPULAR_TOPIC).toString(), actualResult.toString());
	}

	@Test
	public void testGetConcatenatedTitlesByTopic() throws IOException {
		// ~ when:
		Map<Topic, String> actualResult = book.getConcatenatedTitlesByTopic(library);
		// ~ then:
		Assert.assertEquals(readResource(CONCATENATED_TITLES_BY_TOPIC).toString(), actualResult.toString());
	}

	@Test
	public void testGetConcetenatedTitles() {
		String expectedResult = "Fundamentals of Java Programming::Fundamentals of Database::Wings Of Fire::Fundamentals of Middleware";
		// ~ when:
		String actualResult = book.getConcetenatedTitles(library);
		// ~ then:
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetAuthorsForBooks() throws IOException {
		// ~ when:
		List<String> actualResult = book.getAuthorsForBooks(library);
		// ~ then:
		Assert.assertEquals(readResource(AUTHORS_FOR_BOOKS).toString(), actualResult.toString());
	}

	@Test
	public void testGetSortedTitles() {
		NavigableSet<String> expectedResult = new TreeSet<>();
		// Titles are added using add() method
		expectedResult.add("Fundamentals of Database");
		expectedResult.add("Fundamentals of Java Programming");
		expectedResult.add("Fundamentals of Middleware");
		expectedResult.add("Wings Of Fire");
		// ~ when:
		NavigableSet<String> actualResult = book.getSortedTitles(library);
		// ~ then:
		Assert.assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testGetDistributionByCount() {
		Map<Topic, Long> expectedResult = new HashMap<>();
		expectedResult.put(Topic.HISTORY, 1L);
		expectedResult.put(Topic.PROGRAMMING, 3L);
		// ~ when:
		Map<Topic, Long> actualResult = book.getDistributionByCount(library);
		// ~ then:
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void testGetBookListWithVolumeNumbersAndPageCounts() {
		book.getBookListWithVolumeNumbersAndPageCounts(library);
	}

	/**
	 * Utility to read resources.
	 * 
	 * @param fileName
	 * @return String
	 */
	public String readResource(final String fileName) throws IOException {
		return Resources.toString(getResource(fileName), Charsets.UTF_8);
	}

	@Override
	protected void tearDown() {
		book = null;
		java = null;
		database = null;
		wingsOfFire = null;
		middleware = null;
		library = null;
	}

}
