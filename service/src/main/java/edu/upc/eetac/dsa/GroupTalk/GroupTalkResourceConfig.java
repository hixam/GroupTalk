package edu.upc.eetac.dsa.GroupTalk;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by bernat on 16/10/15.
 */
public class GroupTalkResourceConfig extends ResourceConfig {
    public GroupTalkResourceConfig() {
        packages("edu.upc.eetac.dsa.GroupTalk"); //El paquete donde se debe buscar las clases recurso
    }
}
