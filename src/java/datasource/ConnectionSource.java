package datasource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionSource {

    private InitialContext initContext;
    private DataSource ds;
    private static ConnectionSource instance = new ConnectionSource();
    private final Logger logger = LogManager.getLogger(ConnectionSource.class.getName());


    private ConnectionSource() {
        try {
            initContext = new InitialContext();
            ds = (DataSource) initContext.lookup("java:comp/env/jdbc/courses");
        } catch (NamingException e) {
            logger.error(e);
        }

    }

    public static synchronized ConnectionSource getInstance() {
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;

        try {

            connection = ds.getConnection();




        } catch (SQLException e) {
            logger.error(e);
        }
        return connection;
    }



}
