package sda.orange.grcy.log4jDemo;

import org.apache.log4j.Logger;

public class Log4jDemo {

    private final static Logger LOGGER = Logger.getLogger(Log4jDemo.class);
    public static void main(String[] args) {

        System.out.println("Logowanie bez użycia Log4j");
        System.out.println("===========================");
        System.out.println("===========================");
        LOGGER.fatal("Fatal message logged");
        LOGGER.error("Error message logged");
        LOGGER.debug("Debug message logged");
        LOGGER.info("Info message logged");
        LOGGER.trace("Trace message logged");
        LOGGER.warn("Warning message logged");

    }
}
