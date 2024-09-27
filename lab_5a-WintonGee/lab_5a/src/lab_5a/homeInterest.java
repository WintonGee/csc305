package lab_5a;

// Context-homeInterest
public class homeInterest extends calculateInterest {

    homeInterest(double principal, double annual_rate, int time, InterestStrategy interestStrategy) {
        super(principal, annual_rate, time);
        this.strategy = interestStrategy;
    }

    @Override
    void displayInterest() {
        double interestAmount = this.calculate();
        System.out.println("Home Interest: " + interestAmount);
    }
}
