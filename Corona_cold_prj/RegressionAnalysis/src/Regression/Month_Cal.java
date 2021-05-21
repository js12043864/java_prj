package Regression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Month_Cal {
	ArrayList<Integer> count = new ArrayList<Integer>();
	ArrayList<String> date = new ArrayList<String>();
	ArrayList<String> code = new ArrayList<String>();
	
	public double[] Environment() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\temperature.csv"));
		ArrayList<Double> temp = new ArrayList<Double>();
		double[] temperature = new double[12];
		String[] severalLine = new String[400];
		int[] maxDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		int i = 0;
		while (true) {
			String line;
			if ((line = reader.readLine()) == null) {
				break;
			}
			severalLine[i] = line;
			i++;
		}
		for (int j = 8; j < 373; j++) {
			String[] Split = severalLine[j].split(",");
			temp.add(Double.parseDouble(Split[2]));
			date.add(Split[0]);
		}
		for(int l = 0; l < 12; l++) {
			double sum = 0;
			for(int k = 0; k < temp.size(); k++) {
				if(date.get(k).substring(0,7).equals("2018-0" + (l+1))) {
					sum = sum + temp.get(k);
				}else if(date.get(k).substring(0,7).equals("2018-" + (l+1))) {
					sum = sum + temp.get(k);
				}
			}
			temperature[l] = sum/maxDay[l];
		}
		return temperature;
	}
	
	public double[] Humidity() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\humidity.csv"));
		ArrayList<Double> hum = new ArrayList<Double>();
		double[] humidity = new double[12];
		String[] severalLine = new String[400];
		int[] maxDay = {31,28,31,30,31,30,31,31,30,31,30,31};
		int i = 0;
		while (true) {
			String line;
			if ((line = reader.readLine()) == null) {
				break;
			}
			severalLine[i] = line;
			i++;
		}
		for (int j = 17; j < 382; j++) {
			String[] Split = severalLine[j].split(",");
			hum.add(Double.parseDouble(Split[3]));
			date.add(Split[2]);
		}
		for(int l = 0; l < 12; l++) {
			double sum = 0;
			for(int k = 0; k < hum.size(); k++) {
				if(date.get(k).substring(0,7).equals("2018-0" + (l+1))) {
					sum = sum + hum.get(k);
				}else if(date.get(k).substring(0,7).equals("2018-" + (l+1))) {
					sum = sum + hum.get(k);
				}
			}
			humidity[l] = sum/maxDay[l];
		}
		return humidity;
	   }
}
