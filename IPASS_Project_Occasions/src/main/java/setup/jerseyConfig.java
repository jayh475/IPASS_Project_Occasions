package setup;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("restservices")
class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages("cuba.de.jayh.everything.webservices");
        register(RolesAllowedDynamicFeature.class);
    }
}


