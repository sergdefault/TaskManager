package dao;

import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Цымбалюк Сергей on 20.05.2016.
 */
public class UserDAO {
    private Connection connection;
    private String login;
    private String password;

    public UserDAO(String login, String password) {
        this.connection = new DbHelper().getConnection();
        this.login = login;
        this.password = password;
    }

    public User getVerifyUser() {
        User user = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT* from task_manager.users WHERE LOGIN='" + login + "' and PASSWORD='" + password + "';");
            if (rs == null) {
                return null;
            } else {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    user = new User(id,login,password);
                }
            }
        } catch (SQLException e) {

        }
        return user;

    }

    public int createNewUser(String login, String password){
        Statement st=null;
        User user = null;
        int id = 0;
        try {
            st = connection.createStatement();
            st.execute("INSERT INTO task_manager.users (LOGIN,PASSWORD) value ('"+login+"','"+password+"');");
            ResultSet rs=st.executeQuery("SELECT * FROM task_manager.users where LOGIN='"+login+"' and PASSWORD='"+password+"';");
            while (rs.next()){
                id = rs.getInt(1);
            }
            st.execute("CREATE TABLE `task_manager`.`"+id+"` (\n" +
                    "  `TASK_ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `DATE` DATETIME NOT NULL,\n" +
                    "  `DESCRIPTION` VARCHAR(45) NOT NULL,\n" +
                    "  `STATUS` BIT(11) NOT NULL DEFAULT 0,\n" +
                    "  PRIMARY KEY (`TASK_ID`));\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }

    public boolean checkLoginDublicate(String login){
        ResultSet rs=null;
        try {
            Statement statement = connection.createStatement();
            rs = statement.executeQuery("select * from task_manager.users where LOGIN='"+login+"';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(rs==null){
            return true;
        }else {
            return false;
        }
    }
}
