package uj.ii.servlets;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uj.ii.dao.UsersProfileDAO;
import uj.ii.dao.PublicationsDAO;
import uj.ii.transferobjects.UserProfile;
import uj.ii.transferobjects.Publication;

@WebServlet("/publications")
public class PublicationsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        /**
         * ******** Users ********
         */
        UsersProfileDAO usersProfileDAO = (UsersProfileDAO) req.getServletContext().getAttribute("usersProfileDAO");
        List<UserProfile> users = usersProfileDAO.viewUsers();
        req.setAttribute("users", users);

        /**
         * ******** Publications ********
         */
        PublicationsDAO pubDao = (PublicationsDAO) req.getServletContext().getAttribute("publicationsDAO");
        List<Publication> publications = pubDao.viewAllPublications();
        req.setAttribute("publications", publications);

        /**
         * ******** Is authenticated ********
         */
        req.setAttribute("isAuthenticated", req.getSession().getAttribute("user") != null);
        
        RequestDispatcher view = req.getRequestDispatcher("publications.jsp");

        try {
            view.forward(req, resp);
        } catch (ServletException ex) {
            Logger.getLogger(PublicationsServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PublicationsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
