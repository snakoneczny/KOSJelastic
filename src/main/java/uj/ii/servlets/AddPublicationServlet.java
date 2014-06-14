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

import uj.ii.dao.PublicationsDAO;
import uj.ii.dao.PublicationsDAOInterface;

@WebServlet("/addPublication")
public class AddPublicationServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object loginObject = request.getSession().getAttribute("user");
            RequestDispatcher view = request.getRequestDispatcher("");
            
            if (loginObject != null) {
                String login = loginObject.toString();
                PublicationsDAOInterface dao = (PublicationsDAOInterface) request.getServletContext().getAttribute("publicationsDAO");
                dao.addPublication(request.getParameter("name"), request.getParameter("description"), login);

                view = request.getRequestDispatcher("/member?name=" + login);
            }
            
            view.forward(request, response);
            
        } catch (ServletException ex) {
            Logger.getLogger(AddPublicationServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddPublicationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
