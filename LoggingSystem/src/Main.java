import models.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Start Application ===");

        LogProcessor logProcessor = new DebugLogProcessor(new InfoLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(LogType.ERROR, "An error log");
        logProcessor.log(LogType.DEBUG, "A debug log");
        logProcessor.log(LogType.INFO, "An info log");

        System.out.println("=== End Application ===");
    }
}