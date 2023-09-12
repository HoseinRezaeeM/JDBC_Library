package menu;

import author.Author;
import book.Book;
import service.AuthorService;
import service.BookService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    AuthorService authorService = new AuthorService();
    BookService bookService = new BookService();
    Scanner scanner = new Scanner(System.in);

    public Menu() throws SQLException {
    }

    public void firstMenu() throws SQLException {
        System.out.println("\n---------Welcom to Library ---------\n");
        System.out.println("1 - Add Author ");
        System.out.println("2 - Add book");
        System.out.println("3 - Search Book");
        System.out.println("4 - Search Author");
        System.out.println("5 - Delete Book\n");
        System.out.println(" Enter your Select -> ");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                addAuthor();

            case 2:
                addBook();


            default:
                System.out.println("Errorr");

        }

    }

    public void addBook() throws SQLException {
        System.out.println("How many Book add in library ?");
        int tedad = scanner.nextInt();

        for (int i = 1; i <= tedad; i++) {


            System.out.println("Enter title");
            String title = scanner.next();
            System.out.println("Enter printYear");
            String printYear = scanner.next();
            System.out.println("Enter AuthorID");
            int AuthorId = scanner.nextInt();
            Book book = new Book(AuthorId, title, printYear, null);
            bookService.register(book);

        }

    }

    public void addAuthor() throws SQLException {
        System.out.println("How many Author add in library ?");
        int tedad = scanner.nextInt();

        for (int i = 1; i <= tedad; i++) {


            System.out.println("Enter firstName");
            String firstName = scanner.next();
            System.out.println("Enter lastName ");
            String lastName = scanner.next();
            System.out.println("Enter age");
            int age = scanner.nextInt();
            Author author = new Author(null, firstName, lastName, age);
            authorService.register(author);

        }
    }

    public void searchBook() throws SQLException {
        System.out.println("Which your BookID ?");
        int bookid = scanner.nextInt();
        bookService.load(bookid);
    }

    public void searchAuthor() throws SQLException{
        System.out.println("Which your AuthorId ? ");
        int authorid = scanner.nextInt();
        authorService.load(authorid);
    }
}
