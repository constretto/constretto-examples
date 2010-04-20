package org.constretto.examples.dashboard;

/**
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
 */
public class DevelopmentDashboard extends Dashboard {

    @Override
    public String constrettoTags() {
        return "development,constretto,exampletag";
    }

    @Override
    public String constrettoEnv() {
        return "development,constretto,exampleEnv";
    }

    public static void main(String[] args) {
        new DevelopmentDashboard();
    }
}
