package lab_3a;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class Tests {

    // Note:
    // - There is a discount based on the age
    // - Matinee pricing is cheaper
    // - Standard pricing = Adult = Greater than child and less than senior age
    // - LocalTime.of(10, 0) would set the time to 10:00 AM

    /* Tests
        - Invalid Matinee Times, Start time is after end time
        - Matinee pricing
        - Standard Pricing
        - Matinee Senior discount pricing
        - Matinee Child discount pricing
        - Standard Senior discount pricing
        - Standard Child discount pricing
     */

    @Test
    public void testInvalidMatineeTimes() {
        // Invalid Matinee Times, Start time is after end time
        assertThrows(IllegalArgumentException.class, () -> new MovieTicketPriceCalculator(
                LocalTime.of(10, 0), LocalTime.of(0, 0), 12, 65
        ));
    }

    @Test
    public void testMatineePricing() {
        // Matinee pricing => Matinee: 10:00AM to 5:00PM => Test Time: 2PM
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(10, 0), LocalTime.of(17, 0), 12, 65
        );

        int price = calculator.computePrice(LocalTime.of(14, 0), 20);

        assertEquals(2400, price);
    }

    @Test
    public void testStandardPricing() {
        // Standard pricing => Matinee: 10:00AM to 5:00PM => Test Time: 9:00AM
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(10, 0), LocalTime.of(17, 0), 12, 65
        );

        int price = calculator.computePrice(LocalTime.of(9, 0), 20);

        assertEquals(2700, price);
    }

    @Test
    public void testMatineeSeniorDiscountPricing() {
        // Matinee pricing => Matinee: 10:00AM to 5:00PM => Test Time: 2PM
        // MATINEE_PRICE_CENTS = 2400
        // SENIOR_DISCOUNT_CENTS = 400
        // MATINEE_PRICE_CENTS - SENIOR_DISCOUNT_CENTS = 2000
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(10, 0), LocalTime.of(17, 0), 12, 65
        );

        int price = calculator.computePrice(LocalTime.of(14, 0), 100);

        assertEquals(2000, price);
    }

    @Test
    public void testMatineeChildDiscountPricing() {
        // Matinee pricing => Matinee: 10:00AM to 5:00PM => Test Time: 2PM
        // MATINEE_PRICE_CENTS = 2400
        // CHILD_DISCOUNT_CENTS = 300
        // MATINEE_PRICE_CENTS - CHILD_DISCOUNT_CENTS = 2100
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(10, 0), LocalTime.of(17, 0), 12, 65
        );

        int price = calculator.computePrice(LocalTime.of(14, 0), 5);

        assertEquals(2100, price);
    }

    @Test
    public void testStandardSeniorDiscountPricing() {
        // Matinee pricing => Matinee: 10:00AM to 5:00PM => Test Time: 8PM
        // STANDARD_PRICE_CENTS = 2700
        // SENIOR_DISCOUNT_CENTS = 400
        // MATINEE_PRICE_CENTS - SENIOR_DISCOUNT_CENTS = 2300
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(10, 0), LocalTime.of(17, 0), 12, 65
        );

        int price = calculator.computePrice(LocalTime.of(20, 0), 100);

        assertEquals(2300, price);
    }

    @Test
    public void testStandardChildDiscountPricing() {
        // Matinee pricing => Matinee: 10:00AM to 5:00PM => Test Time: 8PM
        // STANDARD_PRICE_CENTS = 2700
        // CHILD_DISCOUNT_CENTS = 300
        // MATINEE_PRICE_CENTS - CHILD_DISCOUNT_CENTS = 2400
        MovieTicketPriceCalculator calculator = new MovieTicketPriceCalculator(
                LocalTime.of(10, 0), LocalTime.of(17, 0), 12, 65
        );

        int price = calculator.computePrice(LocalTime.of(20, 0), 5);

        assertEquals(2400, price);
    }

}
