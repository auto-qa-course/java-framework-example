package commonLibs.utils;

public class SimpleLogger  {
    private String logLevel = "DEBUG";

    public SimpleLogger() {
        super();
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public void log(String message) {
        System.out.println(String.format("%s: %s", logLevel, message));
    }

}
