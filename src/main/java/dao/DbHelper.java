package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Цымбалюк Сергей on 17.05.2016.
 */
public class DbHelper {
    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/task_manager", "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public void close(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
