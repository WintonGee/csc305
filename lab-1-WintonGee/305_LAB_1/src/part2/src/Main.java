import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Get the user's input
        System.out.println("Enter a Celsius to convert to Fahrenheit: ");
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextDouble())
            return;

        // Calculate Fahr and print the output
        double cel = scanner.nextDouble();
        double fahr = celToFahr(cel);
        displayWeatherStatement(fahr);
    }

    // celsius * 1.8 = fahrenheit – 32
    private static double celToFahr(double cel) {
        return cel * 1.8 + 32;
    }

    private static void displayWeatherStatement(double fahr) {
        if (fahr <= 40)
            System.out.println("Cold");
        else if (fahr <= 79)
            System.out.println("Normal");
        else if (fahr <= 99)
            System.out.println("Hot");
        else
            System.out.println("Warning: Heat wave");
    }
}