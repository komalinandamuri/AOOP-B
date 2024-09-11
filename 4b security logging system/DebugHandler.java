public class DebugHandler extends LogHandler {

    public DebugHandler() {
        super(LogLevel.DEBUG);
    }

    @Override
    protected boolean canHandle(String message) {
        return message.startsWith("DEBUG:");
    }

    @Override
    protected void processMessage(String message) {
        System.out.println("DEBUG: " + message.substring(6).trim());
    }
}
