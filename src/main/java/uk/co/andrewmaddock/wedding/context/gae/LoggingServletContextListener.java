package uk.co.andrewmaddock.wedding.context.gae;

import java.util.logging.Handler;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Servlet context listener to replace all log handler formatters with single line log formatter. 
 *
 * @author Andrew Maddock
 *         Date: 07/08/13 14:57
 */
public class LoggingServletContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Replace log handlers formatter with single line log formatter
        Logger logger = Logger.getLogger("");
        for (Handler handler : logger.getHandlers()) {
            handler.setFormatter(new LogFormatter());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) { }
    
}
