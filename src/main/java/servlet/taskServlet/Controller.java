package servlet.taskServlet;

import dao.TaskDAO;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Цымбалюк Сергей on 23.05.2016.
 */
public class Controller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaskDAO td=null;
        String action = req.getParameter("action");
        User user = (User) req.getSession().getAttribute("key");
        if(action!=null){
            td= new TaskDAO(user);
        }
        if(action.equalsIgnoreCase("delete")){
            td.deleteTask(id);
        }else if(action.equalsIgnoreCase("create")){
            String description = req.getParameter("description");
            Task task = new Task(new Date(),description,false);
            td.addTask(task);
        }else if(action.equalsIgnoreCase("update")){
            int taskId = Integer.parseInt(req.getParameter("id"));
        }
        System.out.println(req.getParameter("description"));
        ArrayList<Task>listTasks= td.getAllTasks();
        req.setAttribute("allTasks",listTasks);
        req.getRequestDispatcher("pages/showtasks.jsp").forward(req,resp);
    }

}
