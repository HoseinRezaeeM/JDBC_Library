package service;

import author.Author;
import repository.AuthorRepository;

import java.sql.SQLException;

public class AuthorService {

    final AuthorRepository authorRepository = new AuthorRepository();

    public AuthorService() throws SQLException {
    }

    public void register(Author author) throws SQLException {
        int result = authorRepository.save(author);
        if (result != 0)
            System.out.println(author.getFirstName() + " " + author.getLastnName() + " successfully added to database");
        else System.out.println("Don't add to database!! ");

    }

    public void load(int authorId) throws SQLException {

        authorRepository.load(authorId);
    }

}
