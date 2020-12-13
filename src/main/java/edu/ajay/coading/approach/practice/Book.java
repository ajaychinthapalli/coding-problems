package edu.ajay.coading.approach.practice;

import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 *
 * @author Ajay Chinthapalli
 * @version 1.0
 * @since 2020-12-11
 * @see Mastering Lambdas: Java Programming in a Multicore World (Maurice
 *      Naftalin)
 */
public class Book {

	private String title;
	private List<String> authors;
	private int[] pageCounts;
	private Topic topic;
	private Year pubDate;
	private Double height;

	public Book() {
	}

	public Book(String title, List<String> authors, int[] pageCounts, Topic topic, Year pubDate, Double height) {
		super();
		this.title = title;
		this.authors = authors;
		this.pageCounts = pageCounts;
		this.topic = topic;
		this.pubDate = pubDate;
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public int[] getPageCounts() {
		return pageCounts;
	}

	public Topic getTopic() {
		return topic;
	}

	public Year getPubDate() {
		return pubDate;
	}

	public Double getHeight() {
		return height;
	}

	/**
	 * A list of books.
	 *
	 * @param library
	 * @return List<Book>
	 */
	public List<Book> getListOfBooks(List<Book> library) {
		return library.stream().collect(Collectors.toList());
	}

	/**
	 * A map classifying books by Topic.
	 *
	 * @param library
	 * @return Map<Topic, List<Book>>
	 */
	public Map<Topic, List<Book>> getBooksByTopic(List<Book> library) {
		Map<Topic, List<Book>> booksByTopic = library.stream().collect(Collectors.groupingBy(Book::getTopic));
		return booksByTopic;
	}

	/**
	 * An ordered map from book titles to publication date of latest edition.
	 *
	 * @param library
	 * @return Map<String, Year>
	 */
	public Map<String, Year> getTitleToPublicationDate(List<Book> library) {
		Map<String, Year> titleToPublicationDate = library.stream().collect(Collectors.toMap(Book::getTitle,
				Book::getPubDate, BinaryOperator.maxBy(Comparator.naturalOrder()), TreeMap::new));
		return titleToPublicationDate;
	}

	/**
	 * A map partitioning books into programming (mapped to true) and history
	 * (false).
	 *
	 * @param library
	 * @return Map<Boolean, List<Book>>
	 */
	public Map<Boolean, List<Book>> isProgrammingOrHistory(List<Book> library) {
		Map<Boolean, List<Book>> programmingOrHistory = library.stream()
				.collect(Collectors.partitioningBy(book -> book.getTopic() == Topic.PROGRAMMING));
		return programmingOrHistory;
	}

	/**
	 * A map associating each topic with the book on that topic having the most
	 * authors.
	 *
	 * @param library
	 * @return Map<Topic, Optional<Book>>
	 */
	public Map<Topic, Optional<Book>> getMostAuthorsByTopic(List<Book> library) {
		Map<Topic, Optional<Book>> mostAuthorsByTopic = library.stream().collect(Collectors.groupingBy(Book::getTopic,
				Collectors.maxBy(Comparator.comparing(book -> book.getAuthors().size()))));
		return mostAuthorsByTopic;
	}

	/**
	 * A map associating each topic with the total number of volumes on that topic.
	 *
	 * @param library
	 * @return Map<Topic, Integer>
	 */
	public Map<Topic, Integer> getVolumeCountByTopic(List<Book> library) {
		Map<Topic, Integer> volumeCountByTopic = library.stream().collect(
				Collectors.groupingBy(Book::getTopic, Collectors.summingInt(book -> book.getPageCounts().length)));
		return volumeCountByTopic;
	}

	/**
	 * The topic with the most books.
	 * 
	 * @param library
	 * @return Optional<Topic>
	 */
	public Optional<Topic> getMostPopularTopic(List<Book> library) {
		Optional<Topic> mostPopularTopic = library.stream()
				.collect(Collectors.groupingBy(Book::getTopic, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
		return mostPopularTopic;
	}

	/**
	 * A map from each topic to the concatenation of all the book titles on that
	 * topic.
	 * 
	 * @param library
	 * @return Map<Topic, String>
	 */
	public Map<Topic, String> getConcatenatedTitlesByTopic(List<Book> library) {
		Map<Topic, String> concatenatedTitlesByTopic = library.stream().collect(
				Collectors.groupingBy(Book::getTopic, Collectors.mapping(Book::getTitle, Collectors.joining(";"))));
		return concatenatedTitlesByTopic;
	}

	/**
	 * To concatenate the titles of all books in my library, separating the titles
	 * by a double colon.
	 * 
	 * @param library
	 * @return String
	 */
	public String getConcetenatedTitles(List<Book> library) {
		String concatenatedTitles = library.stream().map(Book::getTitle).collect(Collectors.joining("::"));
		return concatenatedTitles;
	}

	/**
	 * A list of strings, each containing all the authors' names for a single book.
	 * 
	 * The following code will produce a string concatenating the book's authors,
	 * separated by commas(,), beginning with the book's title and ending with a new
	 * line.
	 * 
	 * @param library
	 * @return List<String>
	 */
	public List<String> getAuthorsForBooks(List<Book> library) {
		List<String> authorsForBooks = library.stream()
				.map(book -> book.getAuthors().stream().collect(Collectors.joining(", ", book.getTitle() + ": ", "\n")))
				.collect(Collectors.toList());
		return authorsForBooks;
	}

	/**
	 * To collect stream of elements into a sorted set.
	 * 
	 * We might expect that corresponding overloads of toList and toSet would be
	 * provided to create collectors capable of allowing the specification of custom
	 * suppliers. In fact, rather than providing both toList and toSet with an extra
	 * overload, a single more general method toCollection has been provided
	 * instead. This is more versatile: it allows us to choose not only arbitrary
	 * implementations of Set and List, but of any sub interface of Collection.
	 * (Reference: Mastering Lambdas: Java Programming in a Multicore World. page 78
	 * 
	 * Note: Set <- SortedSet <- NavigableSet <-- TreeSet
	 * 
	 * @param library
	 * @return NavigableSet<String>
	 */
	public NavigableSet<String> getSortedTitles(List<Book> library) {
		NavigableSet<String> sortedTitles = library.stream().map(Book::getTitle)
				.collect(Collectors.toCollection(TreeSet::new));
		return sortedTitles;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", authors=" + authors + ", pageCounts=" + Arrays.toString(pageCounts)
				+ ", topic=" + topic + ", pubDate=" + pubDate + ", height=" + height + "]";
	}

	public enum Topic {
		HISTORY, PROGRAMMING
	}
}
