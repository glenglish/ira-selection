package com.capitalize.iraselection;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/iragroup")
public class IRAGroupResource {
    @Inject
    IRAGroupService service;

    @GET
    @Path("/{id}")
    public IRAGroup getIRAGroup(@PathParam Long id) {
        return service.get(id);
    }

    @GET
    public List<IRAGroup> getIRAGroups() {
        return service.getAll();
    }
}
