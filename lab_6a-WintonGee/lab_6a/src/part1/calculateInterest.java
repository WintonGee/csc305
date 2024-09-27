package part1;

// Note I changed to void in accept to double because I want it to return a value
public abstract class calculateInterest {
	
	/**
	   * principal denotes the loan taken in dollars
	   * annual_rate denotes the annual rate of interest in decimals (5%=0.05)
	   * N denotes the number of times interest is compounded yearly
	   * time denotes the time in years for which interest is calculated
	   */
	double principal; 
    double annual_rate; 
	static final int N = 12; 
	int time; 
	
	public abstract double accept(InterestVisitor obj);
}