package jm.task.core.jdbc.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Util {
   private static final String dbURL = "jdbc:mysql://localhost:3306/test";
   private static final String dbUser = "root";
   private static final String dbPassword ="root";

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection =  DriverManager.getConnection(dbURL, dbUser, dbPassword);
            System.out.println("ok");
        }catch (SQLException throwables){
            throwables.printStackTrace();
            System.out.println("no");
        }
        return connection;
    }
}
