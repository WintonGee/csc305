package part1;

public class ConcreteCreatorInterest extends InterestFactory {

    @Override
    calculateInterest createCalculateInterest(String type, double principal, double annualRate, int time) {
        if (type.equalsIgnoreCase("car"))
            return new carInterest(principal, annualRate, time);
        else if (type.equalsIgnoreCase("home"))
            return new homeInterest(principal, annualRate, time);
        return null;
    }
}
