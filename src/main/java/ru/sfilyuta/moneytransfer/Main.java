package ru.sfilyuta.moneytransfer;

import ru.sfilyuta.moneytransfer.rs.RsPackageInfo;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/";

    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig()
                .packages(RsPackageInfo.class.getPackage().getName())
                .register(new ServiceBinder());
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) {
        startServer();
        System.out.println(String.format("App started. WADL available at %sapplication.wadl", BASE_URI));
    }
}
