package uj.ii.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import uj.ii.dao.PublicationsCacheDAO;
import uj.ii.dao.PublicationsDAO;
import uj.ii.dao.ConferencesDAO;
import uj.ii.dao.PublicationsDAOInterface;
import uj.ii.dao.UsersDAO;
import uj.ii.dao.UsersProfileDAO;

@WebListener
public class ContextStart implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        System.out.println("ContextStart");
        
        UsersDAO usersDAO = new UsersDAO();
        sce.getServletContext().setAttribute("usersDAO", usersDAO);
        
        PublicationsDAOInterface publicationsDAO = new PublicationsCacheDAO( new PublicationsDAO() );
        sce.getServletContext().setAttribute("publicationsDAO", publicationsDAO);
        
        ConferencesDAO conferencesDAO = new ConferencesDAO();
        sce.getServletContext().setAttribute("conferencesDAO", conferencesDAO);
        
        UsersProfileDAO usersProfileDAO = new UsersProfileDAO();
        sce.getServletContext().setAttribute("usersProfileDAO", usersProfileDAO);
  
        System.out.println("ContextStart END!");
        
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
