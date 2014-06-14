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

import uj.ii.dao.PublicationsDAOInterface;
import uj.ii.dao.UsersProfileDAO;
import uj.ii.dao.PublicationsDAO;
import uj.ii.dao.ConferencesDAO;
import uj.ii.transferobjects.UserProfile;
import uj.ii.transferobjects.Publication;
import uj.ii.transferobjects.Conference;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) {
        String login = req.getParameter("name");
        UsersProfileDAO usersProfileDao = (UsersProfileDAO) req.getServletContext().getAttribute("usersProfileDAO");

        /**
         * ******** User ********
         */
        UserProfile user = usersProfileDao.getUserProfile(login);
        req.setAttribute("user", user);

        /**
         * ******** Users ********
         */
        List<UserProfile> users = usersProfileDao.viewUsers();
        req.setAttribute("users", users);

        /**
         * ******** Publications ********
         */
        PublicationsDAOInterface pubDao = (PublicationsDAOInterface) req.getServletContext().getAttribute("publicationsDAO");
        List<Publication> publications = pubDao.viewPublications(login);
        req.setAttribute("publications", publications);

        /**
         * ******** Conferences ********
         */
        ConferencesDAO confDao = (ConferencesDAO) req.getServletContext().getAttribute("conferencesDAO");
        List<Conference> conferences = confDao.viewConferences(login);
        req.setAttribute("conferences", conferences);
        
        /**
         * ******** Is authenticated ********
         */
        boolean isAuthenticated = (req.getSession().getAttribute("user") != null);
        req.setAttribute("isAuthenticated", isAuthenticated);
        
        /**
         * ******** Adding enabled ********
         */
        boolean isUsersPage = login.equals(req.getSession().getAttribute("user"));
        req.setAttribute("addingEnabled", (isAuthenticated && isUsersPage));
        
        RequestDispatcher view = req.getRequestDispatcher("member.jsp");

        try {
            view.forward(req, resp);
        } catch (ServletException ex) {
            Logger.getLogger(MemberServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MemberServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
