package book;

public class Book {

    private Integer bookId;
    private Integer authorId;
    private String title;
    private String printYear;

    public Book(Integer authorId, String title, String printYear,Integer bookId) {
        this.authorId = authorId;
        this.title = title;
        this.printYear = printYear;
        this.bookId=bookId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrintYear() {
        return printYear;
    }

    public void setPrintYear(String printYear) {
        this.printYear = printYear;
    }
}
