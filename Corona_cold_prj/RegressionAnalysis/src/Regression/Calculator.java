package Regression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Calculator {
	// get Monthly
	public double[] get_Monthly(double[] year_Array) {
		double[] month_Array = new double[12];
		double sum = 0;
		int[] day = {31,59,90,120,151,181,212,243,273,304,334,365};
		int i = 0;	
		for(int j = 0; j < 365; j++) {
			sum += year_Array[j];
			if(j == day[i] - 1) {
				if(i == 0) {
					month_Array[i] = sum/day[i];
					i++;
					sum = 0;
				} else {
					month_Array[i] = sum/(day[i]-day[i-1]);
					i++;
					sum = 0;
				}
			}
		}
	return month_Array;
}
	
	public double[] get_9Monthly(double[] year_Array) {
		double[] month_Array = new double[9];
		double sum = 0;
		int[] day = {31,59,90,120,151,181,212,243,273};
		int i = 0;	
		for(int j = 0; j < 273; j++) {
			sum += year_Array[j];
			if(j == day[i] - 1) {
				if(i == 0) {
					month_Array[i] = sum/day[i];
					i++;
					sum = 0;
				} else {
					month_Array[i] = sum/(day[i]-day[i-1]);
					i++;
					sum = 0;
				}
			}
		}
	return month_Array;
}
	
	public double[] get_9Monthly_29(double[] year_Array) {
		double[] month_Array = new double[9];
		double sum = 0;
		int[] day = {31,60,91,121,152,182,213,244,273};
		int i = 0;	
		for(int j = 0; j < 273; j++) {
				sum += year_Array[j];
				if(j == day[i] - 1) {
					if(i == 0) {
						month_Array[i] = sum/day[i];
						i++;
						sum = 0;
					} else {
						month_Array[i] = sum/(day[i]-day[i-1]);
						i++;
						sum = 0;
					}
				}
			}
		return month_Array;
	}
}
