package part1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    // https://refactoring.guru/design-patterns/factory-method
    public static void main(String[] args) {
        ConcreteCreatorInterest carCreator = new ConcreteCreatorInterest();
        calculateInterest carInterest = carCreator.createCalculateInterest("car", 30000, 0.05, 10);
        calculateInterest homeInterest = carCreator.createCalculateInterest("home", 300000, 0.05, 10);

        InterestVisitor carInterestVisitor = new InterestVisitorImplementation();
        double interestCar = carInterest.accept(carInterestVisitor);
        System.out.println("Car Interest: " + interestCar);

        InterestVisitor homeInterestVisitor = new InterestVisitorImplementation();
        double interestHome = homeInterest.accept(homeInterestVisitor);
        System.out.println("Home Interest: " + interestHome);
    }


}
