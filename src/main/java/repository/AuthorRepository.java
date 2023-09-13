package repository;

import author.Author;
import jdbcConnection.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public AuthorRepository() throws SQLException {
    }

    public int save(Author author) throws SQLException {
        String sql = "INSERT INTO author(firstname, lastnname, age) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, author.getFirstName());
        preparedStatement.setString(2, author.getLastnName());
        preparedStatement.setInt(3, author.getAge());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public void load(int authorId) throws SQLException {
        String sql = "SELECT * FROM author WHERE authorid=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,authorId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String firstName = resultSet.getString("firstname");
            String lastName = resultSet.getString("lastnname");
            int age = resultSet.getInt("age");
            System.out.println(" Author infomation -->  firstName : " + firstName + ", lastName : " + lastName + ", Age :" + age);


        }

    }

}