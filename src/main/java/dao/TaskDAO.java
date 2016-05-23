package dao;

import model.Task;
import model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Цымбалюк Сергей on 22.05.2016.
 */
public class TaskDAO {
    private Connection connection;
    private User user;

    public TaskDAO(User user) {
        this.user = user;
        connection = new DbHelper().getConnection();
    }


    public ArrayList<Task> getAllTasks(){
        Statement st=null;
        ArrayList<Task> list = new ArrayList<>();
        try {
            st = connection.createStatement();
            ResultSet rs =st.executeQuery("SELECT * FROM task_manager."+user.getId()+" ;");
            while (rs.next()){
                int idTask = rs.getInt(1);
                Date date = rs.getTimestamp(2);
                String description = rs.getString(3);
                boolean status = rs.getBoolean(4);
                list.add(new Task(idTask,date,description,status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list);
        return list;
    }

    public void deleteTask(int idTask){
        Statement st = null;
        try {
            st=connection.createStatement();
            st.execute("delete from task_manager."+user.getId()+" where TASK_ID="+idTask+";");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addTask(Task task){
        Statement st = null;
        try {
            st = connection.createStatement();
            java.sql.Timestamp dateSql = new java.sql.Timestamp(task.getDate().getTime());
            String ds = task.getDescription();
            st.execute("INSERT into task_manager."+user.getId()+" (DATE ,DESCRIPTION,STATUS) VALUE ('"+dateSql+"','"+ds+"',0);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeStatus (int id ){
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT FROM task_manager."+user.getId()+" WHERE TASK_ID="+id+";");
            Boolean status= false;
            while (rs.next()){
                status = rs.getBoolean(4);
            }
            if(status==false){
                st.execute("UPDATE  task_manager."+user.getId()+" SET STATUS=1 WHERE TASK_ID="+id+";");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 }