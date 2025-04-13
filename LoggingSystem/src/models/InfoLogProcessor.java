package models;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor _nextLogProcessor) {
        super(LogType.INFO, _nextLogProcessor);
    }
}
