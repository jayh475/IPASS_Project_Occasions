package setup;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

public class jerseyConfig {

    @ApplicationPath("restservices")
    public class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            packages("cuba.de.jayh.everything.webservices");
            register(JacksonFeature.class);
        }
    }

}
