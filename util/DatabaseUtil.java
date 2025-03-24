package devcldkai.kaipizzas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {

    private DatabaseUtil(){}

    private static final String URL_DB_CONNECTION = "jdbc:sqlserver://localhost:1433;databaseName=kaipizzas_db;encrypt=false;trustServerCertificate=true";

    private static final String USERNAME = "sa";

    private static final String PASSWORD = "12345";

    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(URL_DB_CONNECTION, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args){
        for(int i = 1; i <= 90; i++){
            System.out.println(i);
        }
    }
}
