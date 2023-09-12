package repository;

import jdbcConnection.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class BookRepository {

    JdbcConnection jdbcConnection=new JdbcConnection();
    Connection connection=jdbcConnection.getConnection();

    public BookRepository() throws SQLException {
    }
}
