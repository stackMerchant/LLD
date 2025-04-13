package models;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor _nextLogProcessor) {
        super(LogType.ERROR, _nextLogProcessor);
    }
}
