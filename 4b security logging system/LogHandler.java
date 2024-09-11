public abstract class LogHandler {
    protected LogHandler nextHandler;
    protected LogLevel level;

    public LogHandler(LogLevel level) {
        this.level = level;
    }

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(String message) {
        if (canHandle(message)) {
            processMessage(message);
        } else if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }

    protected abstract boolean canHandle(String message);
    protected abstract void processMessage(String message);
}
