package uk.co.andrewmaddock.wedding.context.gae;

import java.util.logging.Handler;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 
 *
 * @author Andrew Maddock
 *         Date: 07/08/13 14:57
 */
public class LoggingServletContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Logger logger = Logger.getGlobal().getParent();
        for (Handler handler : logger.getHandlers()) {
            handler.setFormatter(new LogFormatter());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
    
}
