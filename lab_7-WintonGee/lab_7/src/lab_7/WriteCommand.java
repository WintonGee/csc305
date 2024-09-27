package lab_7;

// This is the ConcreteCommand class (Note 3/5) (2 of 2 commands)
public class WriteCommand implements Command {

    // Variables
    // - receiver
    // - Params

    // Functions
    // - execute

    private Document document; // Receiver

    public WriteCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.writeFile();
    }
}
