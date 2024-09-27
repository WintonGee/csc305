package lab_5b;

public interface InterestVisitor {
	double visit(carInterest interest);
	double visit(homeInterest interest);
}
