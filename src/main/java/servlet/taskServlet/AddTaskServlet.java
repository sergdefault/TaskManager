package servlet.taskServlet;

import dao.TaskDAO;
import model.Task;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Цымбалюк Сергей on 22.05.2016.
 */
public class AddTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        User user = (User) req.getSession().getAttribute("key");
        TaskDAO td = new TaskDAO(user);
        Task task = new Task(new Date(),description,false);
        td.addTask(task);
        req.setAttribute("allTasks",td.getAllTasks());
        req.getRequestDispatcher("pages/showtasks.jsp").forward(req,resp);
    }
}
