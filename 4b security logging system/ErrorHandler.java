public class ErrorHandler extends LogHandler {

    public ErrorHandler() {
        super(LogLevel.ERROR);
    }

    @Override
    protected boolean canHandle(String message) {
        return message.startsWith("ERROR:");
    }

    @Override
    protected void processMessage(String message) {
        System.out.println("ERROR: " + message.substring(6).trim());
    }
}
