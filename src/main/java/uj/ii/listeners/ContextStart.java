package uj.ii.listeners;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;
import uj.ii.dao.PublicationsDAO;
import uj.ii.dao.ConferencesDAO;
import uj.ii.dao.UsersDAO;
import uj.ii.dao.UsersProfileDAO;

@WebListener
public class ContextStart implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/DSTestPool");
            
            UsersDAO usersDAO = new UsersDAO(ds);
            sce.getServletContext().setAttribute("usersDAO", usersDAO);
            
            PublicationsDAO publicationsDAO = new PublicationsDAO(ds);
            sce.getServletContext().setAttribute("publicationsDAO", publicationsDAO);
            
            ConferencesDAO conferencesDAO = new ConferencesDAO(ds);
            sce.getServletContext().setAttribute("conferencesDAO", conferencesDAO);
            
            UsersProfileDAO usersProfileDAO = new UsersProfileDAO(ds);
            sce.getServletContext().setAttribute("usersProfileDAO", usersProfileDAO);
        
        } catch (NamingException e) {
            Logger.getLogger(ContextStart.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
