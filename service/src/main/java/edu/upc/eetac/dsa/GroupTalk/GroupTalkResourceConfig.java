package edu.upc.eetac.dsa.GroupTalk;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

/**
 * Created by hixam on 16/10/15.
 */
public class GroupTalkResourceConfig extends ResourceConfig {
    public GroupTalkResourceConfig() {
        packages("edu.upc.eetac.dsa.GroupTalk"); //El paquete donde se debe buscar las clases recurso
        packages("edu.upc.eetac.dsa.beeter.auth");
        register(RolesAllowedDynamicFeature.class);
    }
}
