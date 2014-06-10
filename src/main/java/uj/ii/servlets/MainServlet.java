/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import uj.ii.transferobjects.UserProfile;

@WebServlet("")
public class MainServlet extends HttpServlet {

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
        UsersProfileDAO dao = (UsersProfileDAO) req.getServletContext().getAttribute("usersProfileDAO");
        List<UserProfile> users = dao.viewUsers();
        req.setAttribute("users", users);
        
        /**
         * ******** Is authenticated ********
         */
        req.setAttribute("isAuthenticated", req.getSession().getAttribute("user") != null);
                
        RequestDispatcher view = req.getRequestDispatcher("index.jsp");
        
        try {
            view.forward(req, resp);
        } catch (ServletException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
