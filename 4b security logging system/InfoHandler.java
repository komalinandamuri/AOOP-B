public class InfoHandler extends LogHandler {

    public InfoHandler() {
        super(LogLevel.INFO);
    }

    @Override
    protected boolean canHandle(String message) {
        return message.startsWith("INFO:");
    }

    @Override
    protected void processMessage(String message) {
        System.out.println("INFO: " + message.substring(5).trim());
    }
}
