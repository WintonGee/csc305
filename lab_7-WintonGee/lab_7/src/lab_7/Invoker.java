package lab_7;

import java.util.ArrayList;
import java.util.List;

// This is the Invoker class (Note 4/5)
public class Invoker {

    // Variables
    // - command

    // Functions
    // - SetCommand(command)
    // - execute()

    Command command; // Variable - command

    private List<Command> executionHistory = new ArrayList<>();

    public void setCommand(Command command) { // Function - SetCommand
        this.command = command;
    }

    public void execute() {
        command.execute();

        executionHistory.add(command);
    }

    // Should be able to display which command were executed
    public void printExecutionHistory() {
        System.out.println("Printing the execution history");
        executionHistory.forEach(c -> System.out.println(c.getClass().getSimpleName()));
    }


    // Should be able to execute commands in reverse order
    public void executeReverseOrder() {
        System.out.println("Handling execution in the reversed order");
        for (int i = executionHistory.size() - 1; i >= 0; i--) {
            executionHistory.get(i).execute();
        }
    }

}
