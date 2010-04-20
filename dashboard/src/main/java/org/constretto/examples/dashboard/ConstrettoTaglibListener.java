package org.constretto.examples.dashboard;

import org.constretto.ConstrettoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;

import java.util.Map;

import static org.springframework.beans.factory.config.AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE;

/**
 * @author <a href="mailto:kaare.nilsen@arktekk.no">Kaare Nilsen</a>
 */
public class ConstrettoTaglibListener implements javax.servlet.ServletContextListener{

    public void contextInitialized(ServletContextEvent sce) {
        final WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(sce.getServletContext());
        context.getAutowireCapableBeanFactory().autowireBeanProperties(this,AUTOWIRE_BY_TYPE,true);
    }


    @Autowired
    public void setConfiguration(ConstrettoConfiguration configuration) {
        ConstrettoJSTLFunctions.configuration(configuration);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // Do nothing
    }
}
