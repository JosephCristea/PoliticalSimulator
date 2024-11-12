package Political;

public class Calculations {
	
	private final double[] georgiaPolls = {2, 1, 1, -1, 1, -1, 5, 1, 2, 2};
	private final double georgiaResult = 2.2;
	private double[] customPolls;
	
	
	
	public double average() {
		double totalSum = 0;
		for(int i = 0; i < this.georgiaPolls.length; i++) {
			totalSum += this.georgiaPolls[i];
		}
		return totalSum/this.georgiaPolls.length;
	}
	
	public double error() {
		return this.average() - georgiaResult; 
	}
	
	public void customData(double[] array) {
		this.customPolls = array;
	}
	
	public String toString() {
		String pollingContents = "Georgia Polls: \n{";
		
		for(int i = 0; i < this.georgiaPolls.length; i++) {
			if(i < this.georgiaPolls.length - 1) {
				pollingContents += this.georgiaPolls[i] + ", ";
			} else {
				pollingContents += this.georgiaPolls[i] + "}\n";
			}	
		}
		
		pollingContents += "Your Custom Polls: \n{";
		for(int i = 0; i < this.customPolls.length; i++) {
			if(i < this.customPolls.length - 1) {
				pollingContents += this.customPolls[i] + ", ";
			} else {
				pollingContents += this.customPolls[i] + "}\n";
			}	
		}

		return pollingContents;
		
		
		
	}
	
	
	
	


}
