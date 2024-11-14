package Political;

import java.util.*;

public class Statistics {

	private double standardDeviation;
	private double median;
	private double mean;
	private final double e = 2.71828;
	private static final double INCREMENT = 0.000001; 
	
	
	public String toString() {
		
		String stats = "mean: " + this.mean + " \n";
		stats += "SD: " + this.standardDeviation + "\n";
		return stats;	
	}
	
	public double getAverage() {
		
		return this.mean;
	}
	
	public double getStandardDeviation() {
		
		return this.standardDeviation;
	}
	
	public double getMedian() {
		return this.median;
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
		this.median = middle;
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
	
	public double probability() {
		
		double higherBound = 0;
		double lowerBound = 0;
		double integral = 0;
		double coefficient = Math.pow(this.standardDeviation * Math.sqrt(2 * Math.PI), -1);
		double absoluteNumber = 0;
		
		
		if(this.mean > 0) {
			absoluteNumber = this.mean + (4 * this.standardDeviation);
			
			for(double i = 0; i < absoluteNumber; i+= INCREMENT) {
				lowerBound = Math.pow(e, -0.5 * Math.pow((i - this.mean)/this.standardDeviation, 2));
				higherBound = Math.pow(e, -0.5 * Math.pow(((i + INCREMENT) - this.mean)/this.standardDeviation, 2));
				integral += ((higherBound + lowerBound)/2) * INCREMENT;
			}
			 return coefficient * integral; 
		} else {
			absoluteNumber = this.mean - (4 * this.standardDeviation);
			for(double i = absoluteNumber; i < 0; i+= INCREMENT) {
				lowerBound = Math.pow(e, -0.5 * Math.pow((i - this.mean)/this.standardDeviation, 2));
				higherBound = Math.pow(e, -0.5 * Math.pow(((i + INCREMENT) - this.mean)/this.standardDeviation, 2));
				integral += ((higherBound + lowerBound)/2) * INCREMENT;
			}
			 return coefficient * integral; 
		}

	}
	
	
	
	
	
	
	
	
	
}
