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
		//numberOfSimulations = numberOfSimulations - 1 + 1; 
		
		stat.average(georgiaData);
		stat.standardDeviation(georgiaData);
		stat.confidenceInterval(georgiaData);
		stat.updateTotalNumberSimulations(numberOfSimulations);
		stat.updateEVFrequency();
		
		/*
		System.out.println("Total number of sims: " + stat.getTotalNumberSimulations());
		System.out.println("TEVF: " + stat.getTrumpEVFrequency().length);
		System.out.println("HEVF: " + stat.getHarrisEVFrequency().length);
		*/
		
	
		
		while(counter < numberOfSimulations) {
		
			double[] random = stat.randomMean(georgiaData);
			stat.probability(georgiaData);
			stat.simulation(georgiaData);
			stat.cleanUpProb();
			stat.cleanUpRandom();
			stat.simulationProbability();
			stat.electoralTally();
			Statistics.updateNumberSimulations();
			
			
			
			//System.out.println("Sim number: " + Statistics.getNumberSimulations());
			//System.out.println("Trump EV: " + georgiaData.toString(stat.getTrumpEVFrequency()));
			//System.out.println("Harris EV: " + georgiaData.toString(stat.getHarrisEVFrequency()));
			//System.out.println(georgiaData.toString(random));
			System.out.printf("There is a %.3f", (100 * stat.simulationProbability()));
			System.out.println(" percent that " + georgiaData.merge(random) + " occurs!");
			System.out.println("Trump electoral votes: " + stat.getTrumpEV());
			System.out.println("Harris electoral votes: " + stat.getHarrisEV());
			System.out.println();
			
			stat.resetEV();
			counter++;
			
		}
		System.out.println("Harris won: " + stat.getHarrisWins() + " out of the " + numberOfSimulations + " simulations!");
		System.out.println("Trump won: " + stat.getTrumpWins() + " out of the " + numberOfSimulations + " simulations!");
		scan.close();
		
	}
	
	
}
