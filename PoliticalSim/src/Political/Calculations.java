package Political;


import java.lang.Math;

public class Calculations extends Statistics {
	
	public final double[] georgiaPolls = {2, 1, 1, -1, 1, -1, 5, 1, 2, 2};
	private double[] customPolls;
	
	public void setCustomData(double[] array) {
		this.customPolls = array;
	}
	
	public double[] getGeorgiaData() {
		double[] temp = new double[this.georgiaPolls.length];
		for(int i = 0; i < temp.length; i++) {
			temp[i] = this.georgiaPolls[i];
		}
		return temp;	
	}
	

	public String toString() {
		String pollingContents = "{";
		
		for(int i = 0; i < this.georgiaPolls.length; i++) {
			if(i < this.georgiaPolls.length - 1) {
				pollingContents += this.georgiaPolls[i] + ", ";
			} else {
				pollingContents += this.georgiaPolls[i] + "}\n";
			}	
		}
		return pollingContents;
	}
	
	
	
	
	
	


}
