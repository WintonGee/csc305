package lab_8a;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class BasicIntegerOperations{
	
	public static void main(String[] args) {
		Integer num = 10;
		// displaySquare(num, <Lambda Expression>));
		displaySquare(num, x -> System.out.println("Square of "+num+": " + x * x));

		// if(! (isNegative(num, <Lambda Expression>)) {
		//		System.out.println("Square root of "+num+": "+squareRoot(num, <Lambda Expression>));
		//	}
		if (!isNegative(num, x -> x < 0)) {
			System.out.println("Square root of " + num + ": " + squareRoot(num, Math::sqrt));
		}

		tests();
	}

	// Consumer accepts a single value and does not return anything
	public static void displaySquare(Integer num, Consumer<Integer> lambda) {
		lambda.accept(num);
	}

	// Predicate returns a boolean value
	public static boolean isNegative(Integer num, Predicate<Integer> lambda) {
		return lambda.test(num);
	}

	// It takes in an integer value and returns a double value
	// because math.sqrt returns a double value
	public static Double squareRoot(Integer num, Function<Integer, Double> lambda) {
		return lambda.apply(num);
	}


	public static void tests() {
		testDisplaySquare();
		testIsNegative();
		testSquareRoot();
	}

	private static void testDisplaySquare() {
		// Test displaySquare method
		System.out.println("\n\nTesting displaySquare: ");
		displaySquare(5, x -> System.out.println("Square of " + x + ": " + x * x));
		System.out.println("Expected: 25\n");
	}

	private static void testIsNegative() {
		// Test isNegative method
		System.out.println("Testing isNegative:");
		System.out.println("-10 negative? " + isNegative(-10, x -> x < 0));
		System.out.println("Expected: True\n");
		System.out.println("100 negative? " + isNegative(100, x -> x < 0));
		System.out.println("Expected: False\n");
	}

	private static void testSquareRoot() {
		// Test squareRoot method
		System.out.println("Testing squareRoot:");
		System.out.println("Square root of 16: " + squareRoot(16, Math::sqrt));
		System.out.println("Expected: 4\n");
	}

}
