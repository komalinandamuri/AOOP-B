public class Client {
    public static void main(String[] args) {
        // Create handlers
        LogHandler infoHandler = new InfoHandler();
        LogHandler debugHandler = new DebugHandler();
        LogHandler errorHandler = new ErrorHandler();

        // Chain handlers
        infoHandler.setNextHandler(debugHandler);
        debugHandler.setNextHandler(errorHandler);

        // Create commands
        Command infoCommand = new LogCommand(infoHandler);
        Command debugCommand = new LogCommand(debugHandler);
        Command errorCommand = new LogCommand(errorHandler);

        // Create Logger and add commands
        Logger logger = new Logger();
        logger.addCommand(infoCommand);
        logger.addCommand(debugCommand);
        logger.addCommand(errorCommand);

        // Process messages
        infoCommand.execute("INFO: This is an informational message.");
        debugCommand.execute("DEBUG: This is a debug message.");
        errorCommand.execute("ERROR: This is an error message.");

        // Use logger to process commands
        logger.processCommands();
    }
}
