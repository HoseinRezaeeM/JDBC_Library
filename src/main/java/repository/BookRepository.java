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
        preparedStatement.setInt(1,bookId);
        ResultSet resultSet= preparedStatement.executeQuery();
        if (resultSet.next()){
            Book book = new Book(
                    resultSet.getInt("bookId"),
                    resultSet.getInt("authorId"),
                    resultSet.getString("title"),
                    resultSet.getString("printYear")
            );
            return book;
        }else{
            return null;
        }

    }
    public int delete(int bookId) throws SQLException {
        String sql="DELETE FROM book WHERE bookid=?";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        preparedStatement.setInt(1,bookId);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public Book[] loadBookAuthor (int authorId) throws SQLException{
        String add ="SELECT * FROM book INNER JOIN author b on book.authorid = b.authorid WHERE b.authorid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setInt(1,authorId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Book [] books=new Book[3];
        int i =0;

        while (resultSet.next()){
            books[i] =new Book( resultSet.getInt(1),
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getString(4));
            i++;

        }
        return books;

    }
}
