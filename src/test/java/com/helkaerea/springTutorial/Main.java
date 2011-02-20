package com.helkaerea.springTutorial;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;

public class Main {

    private static final int WEBAPP_PORT = 10026;
    private static final String WEBAPP_LOCATION = "src/main/webapp";

    public static void main(String[] args) throws Exception {
        Server server = new Server(WEBAPP_PORT);
        WebAppContext handler = new WebAppContext();
        handler.setContextPath("/");
        handler.setWar(WEBAPP_LOCATION);
        handler.setExtraClasspath(WEBAPP_LOCATION);
        handler.setLogUrlOnStart(true);
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[] {handler});

        // makes it never add the sessionid parameter to the url
        handler.getSessionHandler().getSessionManager().setSessionIdPathParameterName(null);
        
        // when running the admin and wanting to access it with curl (instead of through browser), run the main with -Djava.net.preferIPv4Stack=true
        // otherwise curl-ing to the url will throw an IllegalStateException saying the ip address is not acceptable
        
        server.setHandler(handlers);
        server.start();
    }
}
