package repository;

import author.Author;
import book.Book;
import jdbcConnection.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public Book load(int bookId)throws SQLException{
        String sql="SELECT * FROM book WHERE bookid=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()){
            Book book = new Book(
                    resultSet.getInt("bookId"),
                    resultSet.getString("authorId"),
                    resultSet.getString("title"),
                    resultSet.getInt("printYear")
            );
            return book;
        }else{
            return null;
        }

    }
}
