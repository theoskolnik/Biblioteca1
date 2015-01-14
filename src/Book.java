/**
 * Created by tbartlett on 1/13/15.
 */
public class Book {

    private String title;
    private String author;
    private String yearPublished;

    public Book(String title, String author, String yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getInformation() {
        String bookInfo = String.format("%-20.20s | %-10.10s | %-4.4s", title, author, yearPublished);
        return bookInfo;
    }
}
