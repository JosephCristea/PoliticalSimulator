package Political;

import java.util.*;

public class Statistics {

	private double standardDeviation;
	private double mean;
	private double lowerBound;
	private double upperBound;
	
	
	private final double e = 2.71828;
	private final double INCREMENT = 0.000001; 
	private final double confidenceConstant = 2.3263;
	
	
	public String toString() {
		String stats = "mean: " + this.mean + " \n";
		stats += "SD: " + this.standardDeviation + "\n";
		return stats;	
	}
	
	public double getAverage() {
		return this.mean;
	}
	
	public double getLowerBound() {
		return this.lowerBound;
	}
	
	public double getUpperBound() {
		return this.upperBound;
	}
	
	public double getStandardDeviation() {
		return this.standardDeviation;
	}
	
	public double average(Calculations calc) {
		double[] array = calc.getGeorgiaData();
		double totalSum = 0;
		
		for(int i = 0; i < array.length; i++) {
			totalSum += array[i];
		}
		this.mean = totalSum/array.length; 
		return totalSum/array.length; 
	}
	
	public double median(Calculations calc) {
		double[] array = calc.getGeorgiaData();
		
		for(int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			for(int j = i; j < array.length; j++) {
				if(array[j] < array[minIndex]) {
					array[minIndex] = array[j];
				}
			}
			double temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp; 
		}
		
		double middle  = 0;
		if(array.length % 2 == 0) {
			int lowerBound = array.length/2;
			middle = (array[lowerBound - 1] + array[lowerBound])/2;
		} else {
			int middleIndex  = (int)array.length/2;
			middle = array[middleIndex];
		}
		return middle;
	}
	
	public double standardDeviation(Calculations calc) {
		double[] array = calc.getGeorgiaData();
		double totalSum = 0;
		
		for(int i = 0; i < array.length; i++) {
			totalSum += array[i];
		}
		
		double mean = totalSum/array.length; 
		
		double summation = 0;
		for(int i = 0; i < array.length; i++) {
			summation += Math.pow(array[i] - mean, 2);
		}
		
		double SD = Math.sqrt(summation/array.length);
		this.standardDeviation = SD;
		return SD;
	}
	
	public void confidenceInterval(Calculations calc) {
		double formula = confidenceConstant * (this.standardDeviation/Math.sqrt(calc.getGeorgiaData().length));
			
		this.upperBound = this.mean + formula;
		this.lowerBound = this.mean - formula;
	}
	
	public double randomMean() {
		Random random = new Random(); 
		double value = random.nextGaussian(this.mean, this.standardDeviation);
	
		while(value < lowerBound || value > upperBound) {
			value = random.nextGaussian(this.mean, this.standardDeviation);
		}
		
		this.mean = value; 
		return value;
	}
	
	public double probability() {
		
		double higherBound = 0;
		double minBound = 0;
		double integral = 0;
		double coefficient = Math.pow(this.standardDeviation * Math.sqrt(2 * Math.PI), -1);
		double absoluteNumber = 0;
		
		
		if(this.mean > 0) {
			absoluteNumber = this.mean + (4 * this.standardDeviation);
			
			for(double i = 0; i < absoluteNumber; i+= INCREMENT) {
				minBound = Math.pow(e, -0.5 * Math.pow((i - this.mean)/this.standardDeviation, 2));
				higherBound = Math.pow(e, -0.5 * Math.pow(((i + INCREMENT) - this.mean)/this.standardDeviation, 2));
				integral += ((higherBound + minBound)/2) * INCREMENT;
			}
			 return coefficient * integral; 
		} else {
			absoluteNumber = this.mean - (4 * this.standardDeviation);
			for(double i = absoluteNumber; i < 0; i+= INCREMENT) {
				minBound = Math.pow(e, -0.5 * Math.pow((i - this.mean)/this.standardDeviation, 2));
				higherBound = Math.pow(e, -0.5 * Math.pow(((i + INCREMENT) - this.mean)/this.standardDeviation, 2));
				integral += ((higherBound + minBound)/2) * INCREMENT;
			}
			 return coefficient * integral; 
		}

	}
	
	
	
	
	
	
	
	
	
	
	
}
