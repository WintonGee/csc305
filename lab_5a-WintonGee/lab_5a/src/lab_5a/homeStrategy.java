package lab_5a;

public class homeStrategy implements InterestStrategy {
    @Override
    public double getInterest(double principal, double annualRate, int time) {
        // principal* Math.pow((1 + rate/calculateInterest.n), calculateInterest.n*time)
        return principal* Math.pow((1 + annualRate/calculateInterest.N), calculateInterest.N*time);
    }
}
