package Political;


public class Calculations  {
	
	private final double[] arizonaPolls = {5, 2, 3, 2, 4, 1, 1, 2, 8, 0};
	private final double[] georgiaPolls = {2, 1, 1, -1, 1, -1, 5, 1, 2, 2};
	private final double[] pennsylvaniaPolls = {1, 1, 0, 1, 1, -2, 0, -2, 6, -1, -2, 2, 0, 1, 2, 0, 0, 0, 0};
	private final double[] northCarolinaPolls = {2, 2, 1, -2, 2, 3, 2, 3, 1, -1, 0};
	private final double[] nevadaPolls = {3, 0, -3, -1, 6, 2, -2, 0, 1, 0};
	private final double[] michiganPolls = {1, -1, 1, 0, -2, 0, -2, 0, 3, 0, -6, 1, -1, 0};
	private final double[] wisconsinPolls = {1, -1, 1, 0, -2, 0, -2, 0, 3, 0, -6, 1, -1, 0};
	
	private final double[][] pollingData = {arizonaPolls, georgiaPolls, michiganPolls, pennsylvaniaPolls, nevadaPolls, northCarolinaPolls, wisconsinPolls}; 
	private final String[] states = {"Arizona", "Georgia", "Michigan", "Pennsylvania", "Nevada", "North Carolina", "Wisconsin"};
	

	
	
	public double[][] getData() {
		double[][] temp = this.pollingData;
		return temp;
	}
	
	public String[] getStates() {
		String[] temp = this.states;
		return temp; 
	}
	
	public String toString() {
		String pollingContents = "";
		
		for(int i = 0; i < pollingData.length; i++) {
			pollingContents += states[i] + ":\n{";
				
			for(int j = 0; j < pollingData[i].length; j++) {
				if(j < pollingData[i].length - 1) {
					pollingContents += pollingData[i][j] + ", ";
				} else {
					pollingContents += pollingData[i][j] + "}";
				}
			}
			pollingContents += "\n";
			
		}
		return pollingContents;
	}
	
	public String toString(double[] array) {
		String pollingContents = "{";
		for(int i = 0; i < array.length; i++) {
			if(i < array.length - 1) {
				pollingContents += array[i] + ", ";
			} else {
				pollingContents += array[i] + "}";
			}
		}
		return pollingContents;
	}
	
	
}


