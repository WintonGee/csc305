package lab_5a;

public class Main {

    // https://refactoring.guru/design-patterns/strategy

    public static void main(String[] args) {
        carInterest carInterestContext = new carInterest(30000, 0.5, 10, new carStrategy());
        carInterestContext.displayInterest();

        homeInterest homeInterestContext = new homeInterest(300000, 0.5, 10, new homeStrategy());
        homeInterestContext.displayInterest();
    }


}
