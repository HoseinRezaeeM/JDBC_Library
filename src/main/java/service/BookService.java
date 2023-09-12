package service;

import book.Book;
import repository.BookRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class BookService {

    BookRepository bookRepository =new BookRepository();
    Scanner scanner=new Scanner(System.in);

    public BookService() throws SQLException {
    }
    public void register(Book book)throws SQLException{
        int result =bookRepository.save(book);
        if(result != 0)
            System.out.println(book.getTitle()+ " successfully added to database");
        else
            System.out.println("Don't add to database!! ");
    }
}
