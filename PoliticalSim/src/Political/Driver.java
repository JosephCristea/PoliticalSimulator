package Political;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		double[] array = {2, 1, 1, -1, 1, -1, 5, 1, 2, 2};
		
		Calculations georgiaProbability = new Calculations(); 
		
		//System.out.println(georgiaProbability.average());
		//System.out.println(georgiaProbability.error());
		
		boolean userChoice = true;
		while(userChoice) {
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
				
				georgiaProbability.customData(customPolls);
				
				System.out.println("\n" + georgiaProbability.toString());
				System.out.print("The average of your custom polls is: ");
				System.out.println(georgiaProbability.average());

			} else {
				System.out.println("invalid input");
				break; 
			}

		}
		
	}

}
