package com.capitalize.iraselection;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path(("/ira"))
public class IRAResource {
    @Inject
    IRAService service;

    @GET
    @Path("/{id}")
    public IRA getIRA(@PathParam Long id) {
        return service.get(id);
    }

    @GET
    public List<IRA> getIRAs() {
        return service.getAll();
    }

    @POST
    @Path("/search")
    public List<IRA> search(@QueryParam boolean automated, @QueryParam boolean advisorAvailable,
                            @QueryParam float feesMin, @QueryParam float feesMax, @QueryParam int easeOfUseMax,
                            @QueryParam int easeOfUseMin, @QueryParam float maxBalance, @QueryParam float minBalance) {

        IRAPrefs prefs = new IRAPrefs();

        prefs.automated = automated;
        prefs.advisor = advisorAvailable;
        prefs.feesMin = feesMin;
        prefs.feesMax = feesMax;
        prefs.easeOfUseMin = easeOfUseMin;
        prefs.easeOfUseMax = easeOfUseMax;
        prefs.minBalanceMax = maxBalance;
        prefs.minBalanceMin = minBalance;

        return service.search(prefs);
    }
}
