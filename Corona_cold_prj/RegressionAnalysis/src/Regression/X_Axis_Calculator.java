package Regression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class X_Axis_Calculator {
	
	// get array of temp(��տµ�) per day(X-axis), 2018
	public double[] get_Temp() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\temperature.csv"));
		ArrayList<Double> temp = new ArrayList<Double>();
		double[] temperature = new double[365];
		String[] severalLine = new String[400];
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
		}
		for (int k = 0; k < temp.size(); k++) {
			temperature[k] = temp.get(k);
		}
		return temperature;
	}

	// ȯ����.2018
	public double[] get_Season() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\temperature.csv"));
		ArrayList<Double> temp = new ArrayList<Double>();
		double[] temperature = new double[365];
		String[] severalLine = new String[400];
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
			temp.add(Double.parseDouble(Split[5]));
		}
		for (int k = 0; k < temp.size(); k++) {
			temperature[k] = temp.get(k);
		}
		return temperature;
	}

	// �ϱ���.2018
	public double[] get_Il_Temp() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\temperature.csv"));
		ArrayList<Double> low = new ArrayList<Double>();
		ArrayList<Double> high = new ArrayList<Double>();
		double[] temperature = new double[365];
		String[] severalLine = new String[400];
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
			low.add(Double.parseDouble(Split[3]));
			high.add(Double.parseDouble(Split[4]));
		}
		for (int k = 0; k < low.size(); k++) {
			temperature[k] = high.get(k) - low.get(k);
		}
		return temperature;
	}

	// �ְ�µ�.2018
	public double[] get_High() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\temperature.csv"));
		ArrayList<Double> high = new ArrayList<Double>();
		double[] temperature = new double[365];
		String[] severalLine = new String[400];
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
			high.add(Double.parseDouble(Split[4]));
		}
		for (int k = 0; k < high.size(); k++) {
			temperature[k] = high.get(k);
		}
		return temperature;
	}

	// �����µ�.2018
	public double[] get_Low() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\temperature.csv"));
		ArrayList<Double> low = new ArrayList<Double>();
		double[] temperature = new double[365];
		String[] severalLine = new String[400];
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
			low.add(Double.parseDouble(Split[3]));
		}
		for (int k = 0; k < low.size(); k++) {
			temperature[k] = low.get(k);
		}
		return temperature;
	}

	// ����.2018
	public double[] get_Hum() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\humidity.csv"));
		ArrayList<Double> Avghumidity = new ArrayList<Double>();
		double[] humidity = new double[365];
		String[] severalLine = new String[400];
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
			Avghumidity.add(Double.parseDouble(Split[4]));
		}
		for (int k = 0; k < Avghumidity.size(); k++) {
			humidity[k] = Avghumidity.get(k);
		}
		return humidity;
	}

	// �̼�����.2018
	public double[] get_Dust() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\dust.csv"));
		ArrayList<Double> dust = new ArrayList<Double>();
		double[] dust_amount = new double[12];
		String[] severalLine = new String[400];
		int i = 0;
		while (true) {
			String line;
			if ((line = reader.readLine()) == null) {
				break;
			}
			severalLine[i] = line;
			i++;
		}
		for (int j = 6; j < 18; j++) {
			String[] Split = severalLine[j].split(",");
			dust.add(Double.parseDouble(Split[3]));
		}
		for (int k = 0; k < dust.size(); k++) {
			dust_amount[k] = dust.get(k);
		}
		return dust_amount;
	}

	// 19�� 1-9��, 20�� 1-9�� ��ձ��, 18��
	public double[] get_Temp_TwoYearCompare() throws IOException {
		double[] temperature = new double[] {-0.9, 1, 7.1, 12.1, 19.4, 22.5, 25.9, 27.2, 22.6,
				1.6, 2.5, 7.7, 11.1, 18, 23.9, 24.1, 26.5, 21.4};
		return temperature;
	}
	//19�� 1~9��, 20�� 1~9�� => �ڷγ�(1)
	public double[] get_Corona() throws IOException {
		double[] temperature = new double[] {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1};
		return temperature;
	}
}
