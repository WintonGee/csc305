package part1;

public class InterestVisitorImplementation implements InterestVisitor {

    @Override
    public double visit(carInterest interest) {
        return interest.principal * (1 + interest.annual_rate * interest.time);
    }

    @Override
    public double visit(homeInterest interest) {
        return interest.principal * Math.pow((1 + interest.annual_rate / calculateInterest.N), calculateInterest.N * interest.time);
    }
}
