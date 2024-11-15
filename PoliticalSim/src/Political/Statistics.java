package Political;

import java.util.*;


public class Statistics {

	private double[] standardDeviation;
	private double[] mean;
	private double[] lowerBound;
	private double[] upperBound;
	private double[] randomizedMeans; 
	private double[] probability;
	private double[] trumpsEVFrequency;
	private double[] harrisEVFrequency;
	private final double[] electoralVotes = {11, 16, 15, 19, 6, 16, 10};
	
	private int trumpEV = 219;
	private int harrisEV = 226;
	private int trumpWins = 0;
	private int harrisWins = 0;
	
	private static int numberSimulations = 0; 
	
	private int totalNumberSimulations = 0; 
	private final double e = 2.71828;
	private final double INCREMENT = 0.00001; 
	private final double confidenceConstant = 2.3263;
	

	
	public String toString() {
		String stats = "mean: " + this.mean + " \n";
		stats += "SD: " + this.standardDeviation + "\n";
		return stats;	
	}
	
	public double[] getAverage() {
		return this.mean;
	}
	
	public double[] getLowerBound() {
		return this.lowerBound;
	}
	
	public double[] getUpperBound() {
		return this.upperBound;
	}
	
	public double[] getStandardDeviation() {
		return this.standardDeviation;
	}
	
	public double[] getRandomizedMeans() {
		return this.randomizedMeans;
	}
	
	public int getTrumpEV() {
		return this.trumpEV;
	}
	
	public int getHarrisEV() {
		return this.harrisEV;
	}
	
	public void resetEV() {
		this.trumpEV = 219;
		this.harrisEV = 226;
	}
	
	public void resetTotals() {
		this.trumpEV = 219;
		this.harrisEV = 226;
		this.trumpWins = 0;
		this.harrisWins = 0;
	}
	
	public int getTrumpWins() {
		return this.trumpWins;
	}
	
	public int getHarrisWins() {
		return this.harrisWins;
	}
	
	public static void updateNumberSimulations() {
		numberSimulations++;
	}
	
	public void updateTotalNumberSimulations(int temp) {
		this.totalNumberSimulations = temp; 
	}
	
	public static int getNumberSimulations() {
		return numberSimulations;
	}
	
	public int getTotalNumberSimulations() {
		return this.totalNumberSimulations;
	}
	
	public double[] getTrumpEVFrequency() {
		return this.trumpsEVFrequency;
	}
	
	public double[] getHarrisEVFrequency() {
		return this.harrisEVFrequency;
	}
	
	public void updateEVFrequency() {
		this.trumpsEVFrequency = new double[this.getTotalNumberSimulations()];
		this.harrisEVFrequency = new double[this.getTotalNumberSimulations()];
	}
	
	
	
	
	
	
	public double[] average(Calculations calc) {
		double[][] array = calc.getData();
		double[] averages = new double[array.length];
		
		for(int i = 0; i < array.length; i++) {
			double totalSum = 0;
			for(int j = 0; j < array[i].length; j++) {
				totalSum += array[i][j];
			}
			averages[i] = totalSum/array[i].length; 
		}
		this.mean = averages;
		return averages;
	}
	
	public double[] standardDeviation(Calculations calc) {
		double[][] array = calc.getData();
		double[] averages = this.mean;
		double[] SD = new double[averages.length];
		
		for(int i = 0; i < array.length; i++) {
			double summation = 0;
			for(int j = 0; j < array[i].length; j++) {
				summation += Math.pow(array[i][j] - averages[i], 2);
			}
			SD[i] = Math.sqrt(summation/array[i].length);
		}
		this.standardDeviation = SD;
		return SD;
	}
	
	public void confidenceInterval(Calculations calc) {
		double[][] array = calc.getData(); 
		double[] low = new double[array.length];
		double[] high = new double[array.length];
		
		for(int i = 0; i < array.length; i++) {
			double formula = confidenceConstant * (this.standardDeviation[i]/Math.sqrt(array[i].length));
			
			low[i] = this.mean[i] - formula;
			high[i] = this.mean[i] + formula;
		}
		this.upperBound = high;
		this.lowerBound = low; 
	}
	
	public double[] randomMean(Calculations calc) {
		Random random = new Random();
		double[][] array = calc.getData();
		double[] randomMeans = new double[array.length];
		
		for(int i = 0; i < array.length; i++) {
			double value = random.nextGaussian(this.mean[i], this.standardDeviation[i]);
			
			while(value < this.lowerBound[i] || value > this.upperBound[i]) {
				value = random.nextGaussian(this.mean[i], this.standardDeviation[i]);
			}
			randomMeans[i] = value; 
		}
		this.randomizedMeans = randomMeans; 
		return this.randomizedMeans;
	}
	
	public double[] probability(Calculations calc) {
		double[][] array = calc.getData();
		double[] temp = new double[array.length];
		
		for(int i = 0; i < array.length; i++) {
			double coefficient = Math.pow(this.standardDeviation[i] * Math.sqrt(2 * Math.PI), -1);
			double integral = 0; 
			
			
			if(this.randomizedMeans[i] > 0) {
				double absoluteNumber = this.randomizedMeans[i] + (4 * this.standardDeviation[i]);
				
				for(double j = 0; j < absoluteNumber; j += INCREMENT) {
					double low = Math.pow(e, -0.5 * Math.pow((j - this.randomizedMeans[i])/this.standardDeviation[i],2));
					double high = Math.pow(e, -0.5 * Math.pow(((j + INCREMENT) - this.randomizedMeans[i])/this.standardDeviation[i],2));
					integral += (high + low)/2 * INCREMENT; 
				}
			} else if (this.randomizedMeans[i] < 0) {
				double absoluteNumber = this.randomizedMeans[i] - (4 * this.standardDeviation[i]);
				
				for(double j = absoluteNumber; j < 0; j += INCREMENT) {
					double low = Math.pow(e, -0.5 * Math.pow((j - this.randomizedMeans[i])/this.standardDeviation[i],2));
					double high = Math.pow(e, -0.5 * Math.pow(((j + INCREMENT) - this.randomizedMeans[i])/this.standardDeviation[i],2));
					integral += (high + low)/2 * INCREMENT; 
				}
			} else {
				integral = 0.5; 
			}
			temp[i] = coefficient * integral; 	
		}
		this.probability = temp;
		return this.probability;
	}
	
	public void cleanUpProb() {
		double[] temp = this.probability;
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = Math.round(temp[i] * 100000d) / 100000d;	
		}
	}
	
	public void cleanUpRandom() {
		double[] temp = this.randomizedMeans;
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = Math.round(temp[i] * 100000d) / 100000d;	
		}
		this.randomizedMeans = temp;
	}
	
	public double simulationProbability() {
		double[] temp = this.probability;
		double product = 1; 
		
		for(int i = 0; i < temp.length; i++) {
			if(this.randomizedMeans[i] < 0) {
				product *= (1 - temp[i]);
			} else if (this.randomizedMeans[i] > 0) {
				product *= temp[i];
			} else {
				product *= 0.5; 
			}
			product = Math.round(product * 100000d) / 100000d;
		}
		return product; 
	}

	public void simulation(Calculations calc) {
		double[] random = this.getRandomizedMeans();
		
		for(int i = 0; i < random.length; i++) {
			if(random[i] < 0) {
				this.harrisEV += this.electoralVotes[i];
			} else {
				this.trumpEV += this.electoralVotes[i];
			}	
		}
		if(this.harrisEV > this.trumpEV) {
			this.harrisWins++;
		} else {
			this.trumpWins++;
		}
	}
	
	public void electoralTally() {
		this.trumpsEVFrequency[Statistics.getNumberSimulations()] = this.getTrumpEV();
		this.harrisEVFrequency[Statistics.getNumberSimulations()] = this.getHarrisEV();
	}
	
	
	
	
	
	
	
}
