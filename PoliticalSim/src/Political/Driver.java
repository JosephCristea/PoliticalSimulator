package Political;


import java.util.Random;
import java.util.Scanner; 


public class Driver {

	public static void main(String[] args) {
		
		
		
		Scanner scan = new Scanner(System.in);
		Calculations georgiaData = new Calculations(); 
		Statistics stat = new Statistics(); 
		Random random = new Random();
		
		
		
		
		boolean userChoice = true;
		while(userChoice) {
			System.out.println("Would you like to run a simulation for georgia?");
			String temp = scan.next();
			temp = temp.toLowerCase();
			
			if(temp.equals("yes") || temp.equals("y)")) {
				
				System.out.println("Using polls from RCP one week leading up the election in Georgia: ");
				System.out.println(georgiaData.toString());
				
				System.out.println("Average: " + stat.average(georgiaData));
				System.out.println("Median: " + stat.median(georgiaData));
				System.out.println("Standard Deviation: " + stat.standardDeviation(georgiaData));
				
				System.out.printf("The probability of the Republican Candidate winning is: %.3f", stat.probability() * 100);
				System.out.println("%.");
				
				System.out.printf("The probability of the Depublican Candidate winning is: %.3f", (1 - stat.probability()) * 100);
				System.out.println("%.");
				
				
				
				Double randomValue = random.nextGaussian();
				System.out.println(randomValue);
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			/*
			System.out.println("Would you like to enter custom polls for Georgia?");
			
			String userResponse = scan.nextLine();
			userResponse = userResponse.toLowerCase();
			
			if(userResponse.equals("y") || userResponse.equals("yes")) {
				System.out.println("How many polls would you like to include?");
				int numberOfPolls = scan.nextInt();
				
				double[] customPolls = new double[numberOfPolls];
				System.out.println("Begin entering your polls: ");
				
				for(int i = 0; i < numberOfPolls; i++) {
					customPolls[i] = scan.nextDouble();
				}
				georgiaData.setCustomData(customPolls);
				
				
				
				System.out.println("\n" + georgiaData.toString());
				System.out.print("The average of your custom polls is: ");
				System.out.println(georgiaProbability.average(georgiaData));
				System.out.print("The median of your custom polls is: ");
				System.out.println(georgiaProbability.median(georgiaData));
				System.out.print("The standard deviation of your custom polls is: ");
				System.out.println(georgiaProbability.standardDeviation(georgiaData)); 
	
				double probability = georgiaProbability.probability();
				
				System.out.println("Candidate A has a " + probability + " percent chance to win.");
				System.out.println("Candidate B has a " + (1 - probability) + " percent chance to win");
				
				
				
				
			} else {
				System.out.println("invalid input");
				break; 
			}
		*/
			
		}
		scan.close();
		
	}

}
