package repository;

import author.Author;
import book.Book;
import jdbcConnection.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookRepository {

    JdbcConnection jdbcConnection=new JdbcConnection();
    Connection connection=jdbcConnection.getConnection();

    public BookRepository() throws SQLException {
    }

    public int save(Book book) throws SQLException {
        String sql="INSERT INTO book(authorid, title, printyear) VALUES (?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1, book.getAuthorId());
        preparedStatement.setString(2,book.getTitle());
        preparedStatement.setString(3,book.getPrintYear());
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
