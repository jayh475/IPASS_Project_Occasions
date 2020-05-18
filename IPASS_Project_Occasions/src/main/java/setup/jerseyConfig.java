package setup;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

public class jerseyConfig {

    @ApplicationPath("restservices")
    public class JerseyConfig extends ResourceConfig {
        public JerseyConfig() {
            packages("");
        }
    }

}
