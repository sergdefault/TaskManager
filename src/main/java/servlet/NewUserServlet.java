package servlet;

import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Цымбалюк Сергей on 22.05.2016.
 */
public class NewUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = null;
        if(login.length()<8){
            req.setAttribute("message"," login must be at least 8 characters ");
            req.getRequestDispatcher("authorization/signup.jsp").forward(req,resp);
        }else if (password.length()<8){
            req.setAttribute("message"," password must be at least 8 characters ");
            req.getRequestDispatcher("authorization/signup.jsp").forward(req,resp);
        }else {
           UserDAO ld = new UserDAO(login,password);
           boolean verify = ld.checkLoginDublicate(login);
            if(!verify){
                ld.createNewUser(login,password);
                user=new UserDAO(login,password).getVerifyUser();
                req.getSession().setAttribute("key",user);
                req.getRequestDispatcher("pages/showtasks.jsp").forward(req,resp);
            }else {
                req.setAttribute("message"," login is not available, enter a different username  ");
                req.getRequestDispatcher("authorization/signup.jsp").forward(req,resp);

            }
        }
    }
}
