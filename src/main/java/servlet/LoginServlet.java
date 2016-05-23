package servlet;

import dao.TaskDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Цымбалюк Сергей on 17.05.2016.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new UserDAO(login,password).getVerifyUser();
        HttpSession session = null;
        if(user==null){
            req.setAttribute("message", new String("login or password failed"));
            req.getRequestDispatcher("authorization/login.jsp").forward(req,resp);
        }else{
            session =req.getSession();
            session.setAttribute("key",user);
            req.setAttribute("name", user.getId());
            req.setAttribute("allTasks", new TaskDAO(user).getAllTasks());
            req.getRequestDispatcher("pages/showtasks.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/authorization/registration.jsp").forward(req, resp);

    }
}
