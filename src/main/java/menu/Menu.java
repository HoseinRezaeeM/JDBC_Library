package menu;

import book.Book;
import service.AuthorService;
import service.BookService;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    AuthorService authorService = new AuthorService();
    BookService bookService = new BookService();
    Scanner scanner=new Scanner(System.in);

    public Menu() throws SQLException {
    }

    public void firstMenu() throws SQLException{
        System.out.println("---------Welcom to Library ---------");
        System.out.println("1 - Add Book ");
        System.out.println("2 - Add Author");
        System.out.println("3 - Search Book");
        System.out.println("4 - Search Author");
        System.out.println("5 - Delete Book");
        System.out.println(" Enter your Select ");
        int select =scanner.nextInt();
        switch (select){
            case 1:

        }

    }
    public void addBook() throws SQLException {
        System.out.println("How many Book add in library ?");
        int tedad =scanner.nextInt();

        for (int i = 1; i <= tedad; i++) {


            System.out.println("Enter title");
            String title = scanner.nextLine();
            System.out.println("Enter printYear");
            String printYear = scanner.nextLine();
            System.out.println("Enter AuthorID");
            int AuthorId = scanner.nextInt();
            Book book =new Book(AuthorId,title,printYear,null);
            bookService.register(book);

        }

    }
}
