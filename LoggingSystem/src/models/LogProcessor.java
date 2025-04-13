package models;

public class LogProcessor {
    LogType logType;
    LogProcessor nextLogProcessor;

    LogProcessor(LogType _logType, LogProcessor _nextLogProcessor) {
        logType = _logType;
        nextLogProcessor = _nextLogProcessor;
    }

    public void log(LogType suppliedLogType, String logMessage) {
        if (suppliedLogType == logType) {
            System.out.println(logType.toString() + " => " + logMessage);
        } else if (nextLogProcessor != null) {
            nextLogProcessor.log(suppliedLogType, logMessage);
        }
    }
}
