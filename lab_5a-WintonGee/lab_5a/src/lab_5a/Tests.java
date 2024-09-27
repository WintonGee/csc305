package lab_5a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    @Test
    public void testCarInterestCalculation() {
        InterestStrategy carInterestStrategy = new carStrategy();
        carInterest carInterestContext = new carInterest(30000, 0.05, 10, carInterestStrategy);
        double carInterest = carInterestContext.calculate();
        assertEquals(45000.0, carInterest, 0.001);
    }

    @Test
    public void testHomeInterestCalculation() {
        InterestStrategy homeInterestStrategy = new homeStrategy();
        homeInterest homeInterestContext = new homeInterest(300000, 0.05, 10, homeInterestStrategy);
        double homeInterest = homeInterestContext.calculate();
        assertEquals(494102.84, homeInterest, 0.01);
    }

}
