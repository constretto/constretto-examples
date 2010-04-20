package org.constretto.examples.dashboard;

import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.webapp.WebAppContext;

import java.io.File;

/**
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
 */
public abstract class Dashboard {

    public abstract String constrettoTags();

    public abstract String constrettoEnv();

    public Dashboard() {
        System.setProperty("CONSTRETTO_TAGS", constrettoTags());
        System.setProperty("CONSTRETTO_ENV", constrettoEnv());

        final Server server = new Server();
        final Connector connector = new SelectChannelConnector();
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});
        final WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setWar(getWebAppDir(this.getClass()));
        server.addHandler(context);

        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Helper method, to resolve correct base-dir for the webapp.
     * This is really not neccecary when using eclipse, but since
     * intellij has a kind a retard way of setting up projects,
     * this little util goes a long way of makin it simpler to use.
     *
     * Basically looking for the closest pom file :)
     *
     */
    private File getBaseDir(Class aClass) {
        String basedir = System.getProperty("basedir");
        if (basedir != null) {
            return new File(basedir);
        } else {
            File file = new File(aClass.getProtectionDomain().getCodeSource().getLocation().getPath());
            if (!file.exists()) {
                throw new RuntimeException("Unable to find basedir");
            }
            while (!new File(file, "pom.xml").exists()) {
                file = file.getParentFile();
                if (file == null) {
                    throw new RuntimeException("Unable to find basedir");
                }
            }
            return file;
        }
    }

    private String getWebAppDir(Class aClass) {
        File dir = new File(getBaseDir(aClass), "src/main/webapp");
        if (!dir.exists()) {
            throw new RuntimeException("Unable to find web application directory");
        }
        return dir.toString();
    }

}
