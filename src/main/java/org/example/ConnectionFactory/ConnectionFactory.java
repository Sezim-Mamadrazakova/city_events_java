package org.example.ConnectionFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory implements ConnectionBuilder {

    private DataSource dataSource;
    public ConnectionFactory() {
        try {
            Context cxt = new InitialContext();
            dataSource = (DataSource) cxt.lookup("java:/comp/env/jdbc/city_events");

        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection()  {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
