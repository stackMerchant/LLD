package models;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor _nextLogProcessor) {
        super(LogType.DEBUG, _nextLogProcessor);
    }
}
