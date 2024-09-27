package part1;

public abstract class InterestFactory {

    abstract calculateInterest createCalculateInterest(String type, double principal, double annualRate, int time);

}
