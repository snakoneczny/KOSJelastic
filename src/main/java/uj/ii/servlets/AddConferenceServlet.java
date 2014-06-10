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
import uj.ii.dao.ConferencesDAO;

@WebServlet("/addConference")
public class AddConferenceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            Object loginObject = request.getSession().getAttribute("user");
            RequestDispatcher view = request.getRequestDispatcher("");
            
            if(loginObject != null) {
                String login = loginObject.toString();
                ConferencesDAO dao = (ConferencesDAO) request.getServletContext().getAttribute("conferencesDAO");
                dao.addConference(request.getParameter("name"), request.getParameter("description"), login);

                view = request.getRequestDispatcher("/member?name=" + login);
            }
            
            view.forward(request, response);
        
        } catch (ServletException ex) {
            Logger.getLogger(AddConferenceServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddConferenceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
