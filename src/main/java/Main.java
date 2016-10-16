import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by vladislav on 16.10.16.
 */
public class Main {

    @SuppressWarnings("OverlyBroadThrowsClause")
    public static void main(String[] args) throws Exception {
        final int port = 8080;
        final Server server = new Server(port);
        final ServletContextHandler contextHandler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        final ResourceConfig config = new ResourceConfig(Servlet.class);
        contextHandler.addServlet(new ServletHolder(new ServletContainer(config)), "/*");
        server.setHandler(contextHandler);

        server.start();
        server.join();
    }

}
