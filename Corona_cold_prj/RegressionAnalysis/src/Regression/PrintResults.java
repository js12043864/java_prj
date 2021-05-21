package Regression;

import java.text.DecimalFormat;

public class PrintResults {
	DecimalFormat df = new DecimalFormat("0.######");
	
	public static String nameNew(String name, int length) {
		String temp = name + "                                ";
		String nameNew = new String(temp.getBytes(), 0, length);
		
		return nameNew;
	}
	
	public void printRSquare(double[] rsq) {
		System.out.printf("%38s\n", "[ Regression Analysis ]");
		System.out.println("========================================================");
		System.out.println("R square: " + df.format(rsq[0]));
		System.out.println("Adjusted R square: " + df.format(rsq[1]));
		System.out.println("========================================================");
	}
	
	public void printIndependentsResult(double[] pValue, double[] coefficient, double[] vif, String[] xName) {
		System.out.printf("%22s%18s%11s","P-value","Coefficient","VIF");
		System.out.println("\n--------------------------------------------------------");
		for (int i = 0; i < xName.length; i++) {
			System.out.printf("%s%s%s%s\n",nameNew(xName[i], 15),
							nameNew(df.format(pValue[i]), 15), 
							nameNew(df.format(coefficient[i]), 15),
							nameNew(df.format(vif[i]),15));			
		}
		System.out.println("========================================================");

	}
}
