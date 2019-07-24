package ee.language.api;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ee.language.domain.GreetingsService;
import ee.language.app.qualifiers.JPABased;
import ee.language.domain.GreetingDescription;;

@Path("describe")
@RequestScoped
public class GreetController {

    @Inject
    @JPABased
    private GreetingsService greetService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GreetingDescription> listAll(){
        return greetService.retrieveGreetings();
    }

    @GET
    @Path("/{greeting}")
    @Produces(MediaType.APPLICATION_JSON)
    public GreetingDescription describe(@PathParam("greeting") String greeting) {
        return greetService.describeGreetings(greeting);
    }
}