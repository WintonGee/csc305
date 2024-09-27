package part1;

public interface InterestVisitor {
	double visit(carInterest interest);
	double visit(homeInterest interest);
}
