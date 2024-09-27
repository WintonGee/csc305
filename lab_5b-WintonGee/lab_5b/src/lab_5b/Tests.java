package lab_5b;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Concrete element (carInterest,homeInterest) implements the element interface (calculateInterest)
// Visitors implement the visitor interface (InterestVisitor)

public class Tests {

    @Test
    public void testCarInterestCalculation() {
        calculateInterest carInterest = new carInterest(30000, 0.05, 10);

        InterestVisitor carInterestVisitor = new InterestVisitorImplementation();
        double interest = carInterest.accept(carInterestVisitor);
        assertEquals(45000.0, interest, 0.001);
    }

    @Test
    public void testHomeInterestCalculation() {
        calculateInterest homeInterest = new homeInterest(300000, 0.05, 10);

        InterestVisitor homeInterestVisitor = new InterestVisitorImplementation();
        double interest = homeInterest.accept(homeInterestVisitor);
        assertEquals(494102.84, interest, 0.1);
    }
}
