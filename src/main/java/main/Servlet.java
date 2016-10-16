package main;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Random;

/**
 * Created by vladislav on 16.10.16.
 */
@Singleton
@Path("/")
public class Servlet {
    static final Random RANDOM = new Random();

    @GET
    public Response clear() {
        try {
            final int sleepMSec = 500;
            Thread.sleep(RANDOM.nextInt(sleepMSec));
        } catch (InterruptedException ignored) {}
        return Response.status(Response.Status.OK).entity("Hello from backend").build();
    }
}
