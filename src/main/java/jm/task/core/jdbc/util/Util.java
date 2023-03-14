package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Util {
    private static final String dbURL = "jdbc:mysql://localhost:3306/test";
    private static final String dbUser = "root";
    private static final String dbPassword = "root";
    private static SessionFactory sessionFactory;

    public Util() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            System.out.println("ok");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("no");
        }
        return connection;
    }

    public static SessionFactory getConcreteSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/test");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "root");

                sessionFactory = new Configuration().addAnnotatedClass(User.class)
                        .setProperties(properties)
                        .buildSessionFactory();
            } catch (Exception ex) {
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
}
