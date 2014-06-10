package uj.ii.servlets;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uj.ii.dao.UsersDAO;
import uj.ii.helpers.LoginHelper;
import uj.ii.tools.Encryption;
import uj.ii.transferobjects.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String login = request.getParameter("login");
            String pass = request.getParameter("pass");
            
            LoginHelper helper = new LoginHelper();
            
            boolean isError = false;
            if (login == null || login.trim().equals("")) {
                String loginMessage = "Wrong login ";
                helper.setLoginMessage(loginMessage);
                isError = true;
            }
            
            if (pass == null || pass.trim().equals("")) {
                String passMessage = "Wrong password";
                helper.setPassMessage(passMessage);
                isError = true;
            }
            UsersDAO dao = (UsersDAO) request.getServletContext().getAttribute("usersDAO");
            
            if (!dao.isUser(new User(login, Encryption.md5(pass)))) {
                String loginMessage = "Bad data logging";
                helper.setLoginMessage(loginMessage);
                isError = true;
            }
            
            if (!isError) {
                request.getSession().setAttribute("user", login);
                RequestDispatcher dis = request.getRequestDispatcher("/");
                dis.forward(request, response);
            } else {
                helper.setLogin(login);
                request.setAttribute("loginHelper", helper);
                RequestDispatcher dis = request.getRequestDispatcher("/");
                dis.forward(request, response);
            }
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
