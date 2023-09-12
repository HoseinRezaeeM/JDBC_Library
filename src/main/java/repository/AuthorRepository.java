package repository;

import jdbcConnection.JdbcConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class AuthorRepository {

    JdbcConnection jdbcConnection=new JdbcConnection();
    Connection connection=jdbcConnection.getConnection();

    public AuthorRepository() throws SQLException {
    }


}
