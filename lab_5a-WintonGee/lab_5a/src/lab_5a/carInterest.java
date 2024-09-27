package lab_5a;

// Context-carInterest
public class carInterest extends calculateInterest {
    carInterest(double principal, double annual_rate, int time, InterestStrategy interestStrategy) {
        super(principal, annual_rate, time);
        this.strategy = interestStrategy;
    }

    @Override
    void displayInterest() {
        double interestAmount = this.calculate();
        System.out.println("Car Interest: " + interestAmount);
    }
}
