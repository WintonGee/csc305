package lab_7;

// This is the client class
// This class creates ConcreteCommand object and sets the receiver
public class Main {

    public static void main(String[] args) {
        Document document = new Document();
        Invoker invoker = new Invoker();

        // ConcreteCommand Objects
        ReadCommand readCommand = new ReadCommand(document);
        WriteCommand writeCommand = new WriteCommand(document);

        // Set and execute read command
        invoker.setCommand(readCommand);
        invoker.execute();

        // Set and execute write command
        invoker.setCommand(writeCommand);
        invoker.execute();

        // This stuff is for the demonstration purposes
        invoker.execute();
        invoker.setCommand(readCommand);
        invoker.execute();

        // This is used to show which commands were executed
        invoker.printExecutionHistory();

        // This is used to execute commands in reverse order
        invoker.executeReverseOrder();
    }

}
