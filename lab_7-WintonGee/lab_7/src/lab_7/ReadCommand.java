package lab_7;

// This is the ConcreteCommand class (Note 3/5) (1 of 2 commands)
public class ReadCommand implements Command {

    // Variables
    // - receiver
    // - Params

    // Functions
    // - execute


    private Document document; // Receiver

    public ReadCommand(Document document) {
        this.document = document;
    }

    @Override
    public void execute() {
        document.readFile();
    }
}