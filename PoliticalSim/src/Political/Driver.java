package Political;
import java.util.Scanner; 

public class Driver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Calculations georgiaData = new Calculations(); 
		Statistics stat = new Statistics(); 

		System.out.println("How many simulations would you like to run?");
		int numberOfSimulations = scan.nextInt();
		int counter = 0; 
		
		System.out.println("\nUsing polls from RCP one week leading up the election in Georgia: ");
		System.out.println(georgiaData.toString());
		
		System.out.println("Average: " + stat.average(georgiaData));
		System.out.println("Median: " + stat.median(georgiaData));
		System.out.println("Standard Deviation: " + stat.standardDeviation(georgiaData));
		System.out.println();
		stat.confidenceInterval(georgiaData);
		
		
		while(counter < numberOfSimulations) {
			stat.randomMean();
			double mean = stat.probability();
			
			if(mean < 0) { //%.0f
				System.out.printf("The probability of Harris winning is: %.4f", 100 * mean);
				System.out.print(" percent!");
			} else if (mean > 0) {
				System.out.printf("The probability of Trump winning is: %.4f", 100 * mean);
				System.out.print(" percent!");
			} else {
				System.out.println("Both have equal chances!");
			}
			
			System.out.println();
			counter++;
			
	
			//System.out.println();
			//System.out.println("Random: " + stat.randomMean());
			//System.out.println("Mean: "  + stat.getAverage() + ", Low: " + stat.getLowerBound() + ", High: "  + stat.getUpperBound() + ", SD: " + stat.getStandardDeviation());
			//System.out.println("Probability: " + stat.probability());
		}
		
		scan.close();
		
	}

}
