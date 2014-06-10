package uj.ii.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uj.ii.dao.UsersProfileDAO;
import uj.ii.transferobjects.UserProfile;


@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            Object loginObject = request.getSession().getAttribute("user");
            RequestDispatcher view = request.getRequestDispatcher("");
            
            if (loginObject != null) {
                String login = loginObject.toString();
                UsersProfileDAO dao = (UsersProfileDAO) request.getServletContext().getAttribute("usersProfileDAO");
                
                dao.updateProfile(new UserProfile(login, request.getParameter("firstName"),
                        request.getParameter("lastName"),
                        request.getParameter("email"),
                        request.getParameter("address"),
                        request.getParameter("office"),
                        request.getParameter("phone"),
                        request.getParameter("officeHours"),
                        request.getParameter("mainInterests"),
                        request.getParameter("cv")));
                
                view = request.getRequestDispatcher("/member?name=" + login);
            }
            
            view.forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
