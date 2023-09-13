package service;

import book.Book;
import repository.BookRepository;

import java.sql.SQLException;
import java.util.Arrays;


public class BookService {

    BookRepository bookRepository = new BookRepository();


    public BookService() throws SQLException {
    }

    public void register(Book book) throws SQLException {
        int result = bookRepository.save(book);
        if (result != 0)
            System.out.println(book.getTitle() + " successfully added to database");
        else
            System.out.println("Don't add to database!! ");
    }

    public void load(int bookId) throws SQLException {
        System.out.println(bookRepository.load(bookId));

    }

    public void delete(int bookId) throws SQLException {
        int result = bookRepository.delete(bookId);
        if (result != 0)
            System.out.println("BookID : "+bookId + " successfully delete to database");
        else
            System.out.println("Don't delete to database!! ");
    }

    public void loadAllAuthorBook(int authorId) throws SQLException {
        Book [] books=bookRepository.loadBookAuthor(authorId);
        System.out.println(Arrays.toString(books));
    }
}
