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
		
		/*
		System.out.println("\nUsing polls from RCP one week leading up the election in several key states: ");
		System.out.println(georgiaData.toString());
		System.out.println("Means: " + georgiaData.toString(stat.average(georgiaData)));
		System.out.println("SD: " + georgiaData.toString(stat.standardDeviation(georgiaData)));
		
	
		
		System.out.println("Lower Bound: " + georgiaData.toString(stat.getLowerBound()));
		System.out.println("Upper Bound: " + georgiaData.toString(stat.getUpperBound()));
		System.out.println();
		*/
		
	
		stat.average(georgiaData);
		stat.standardDeviation(georgiaData);
		stat.confidenceInterval(georgiaData);
		while(counter < numberOfSimulations) {
			//System.out.println("Random mean: " + georgiaData.toString(stat.randomMean(georgiaData)));
			//System.out.println("Probabilites: " + georgiaData.toString(stat.probability(georgiaData)));
			georgiaData.toString(stat.randomMean(georgiaData));
			
			stat.simulation(georgiaData);
			System.out.println("Trump electoral votes: " + stat.getTrumpEV());
			System.out.println("Harris electoral votes: " + stat.getHarrisEV());
			stat.resetEV();
			System.out.println();
			
			counter++;
			
			
			/*
			double[] value = stat.probability(georgiaData); 
			String[] states = georgiaData.getStates();
			
			System.out.println();
			
			double[] temp = stat.getRandomizedMeans();
			for(int i = 0; i < temp.length; i++) {
				if(temp[i] > 0) {
					System.out.println("Trumps chances of winning " + states[i] + ": " + 100 * value[i]);
				} else if (temp[i] < 0) {
					System.out.println("Harris chances of winning " + states[i] + ": " + 100 * value[i]);
				} else {
					System.out.println("They both have an equal chance in " + states[i]);
				}
			}
			*/
			
		}
		System.out.println("Harris won: " + stat.getHarrisWins() + " out of the " + numberOfSimulations + " simulations!");
		System.out.println("Trump won: " + stat.getTrumpWins() + " out of the " + numberOfSimulations + " simulations!");
		scan.close();
		
	}

}
