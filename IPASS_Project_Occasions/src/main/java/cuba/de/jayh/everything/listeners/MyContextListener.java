package cuba.de.jayh.everything.listeners;

import cuba.de.jayh.everything.model.Car;
import reactor.core.scheduler.Schedulers;
import reactor.netty.http.HttpResources;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.Duration;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* Overige code, bijvoorbeeld om naar Azure te schrijven! */

        Schedulers.shutdownNow();
        HttpResources.disposeLoopsAndConnectionsLater(Duration.ZERO, Duration.ZERO).block();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Car.createCar("Volkswagen Polo 1.6 AUTOMAAT", "https://media.autoweek.nl/m/pyryc27bzexp_800.jpg", 2000, 2016, 1800, "diesel", "73-MG-HJ", "Volkswagen", "Polo 1.6");
        Car.createCar("Fiat punto", "https://cdn.autowereld.nl/I392904122/1280x0/fiat-punto-evo-1-3-m-jet-street-airco-cruise-lm-velgen-pdc-plaatje.jpg", 30000, 2010,8000,  "diesel","18-ZH-JP","Fiat", "punto" );




    }
}

