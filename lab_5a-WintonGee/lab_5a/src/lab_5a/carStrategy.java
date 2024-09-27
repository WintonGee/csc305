package lab_5a;

public class carStrategy implements InterestStrategy {
    @Override
    public double getInterest(double principal, double annualRate, int time) {
        return principal* (1+annualRate*time);
    }
}
