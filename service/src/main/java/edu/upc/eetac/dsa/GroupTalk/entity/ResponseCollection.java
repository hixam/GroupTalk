package edu.upc.eetac.dsa.GroupTalk.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.ws.rs.core.Link;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bernat on 25/10/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseCollection {
    private List<Link> links;
    private List<Response> responses = new ArrayList<>();

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> groups) {
        this.responses = groups;
    }
}
