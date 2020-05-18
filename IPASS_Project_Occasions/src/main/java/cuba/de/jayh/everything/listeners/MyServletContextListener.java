package cuba.de.jayh.everything.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce){
        System.out.println("applicatie is aan het opstarten!");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("applicatie gaat afsluiten");

    }


}
