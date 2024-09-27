package part1;

public class carInterest extends calculateInterest {

    carInterest(double principal, double annual_rate, int time) {
        this.principal = principal;
        this.annual_rate = annual_rate;
        this.time = time;
    }

    @Override
    public double accept(InterestVisitor visitor) {
        return visitor.visit(this);
    }

}
