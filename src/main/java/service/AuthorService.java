package service;

import author.Author;
import repository.AuthorRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthorService {

    final AuthorRepository authorRepository=new AuthorRepository();
    Scanner scanner=new Scanner(System.in);

    public AuthorService() throws SQLException {
    }

    public void register(Author author) throws SQLException {
        int result=authorRepository.save(author);
        if(result != 0)
            System.out.println(author.getFirstName() +" "+author.getLastnName()+ " successfully added to database");
        else
            System.out.println("Don't add to database!! ");

    }

    public Author load(int authorId)throws SQLException{
        Author author=authorRepository.load(authorId);
        return author;
    }

}
