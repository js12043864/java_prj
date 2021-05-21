package Regression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Y_Axis_Calculator {
	
	// ����.2018 1~12
	public double[] get_Cold() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\cold.csv"));
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> code = new ArrayList<String>();
		double[] coldcount = new double[365];
		String[] severalLine = new String[42000];
		int i = 0;
		while (true) {
			String line;
			if ((line = reader.readLine()) == null) {
				break;
			}
			severalLine[i] = line;
			i++;
		}
		for (int j = 24838; j < 31043; j++) {
			String[] Split = severalLine[j].split(",");
			count.add(Integer.parseInt(Split[2]));
			date.add(Split[0]);
			code.add(Split[1]);
		}
		for (int k = 0; k < MonthCount(date, count, code).size(); k++) {
			coldcount[k] = MonthCount(date, count, code).get(k);
		}
		return coldcount;
	}

	// ����.2018 1~12
	public ArrayList<Integer> MonthCount(ArrayList<String> date, ArrayList<Integer> count, ArrayList<String> code) {// 18��
		ArrayList<Integer> monthly = new ArrayList<Integer>();
		for (int i = 0; i < 12; i++) {
			int sum = 0;
			for (int k = 0; k < date.size(); k++) {
				if (date.get(k).substring(0, 6).equals("20180" + (i + 1)) && code.get(k).equals("11")) {
					monthly.add(count.get(k));
				} else if (date.get(k).substring(0, 6).equals("2018" + (i + 1)) && code.get(k).equals("11")) {
					monthly.add(count.get(k));
				}
			}
		}
		return monthly;
	}

	// ����.2019.1~9
	public double[] get_Cold2019() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\cold.csv"));
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> code = new ArrayList<String>();
		double[] coldcount = new double[273];
		String[] severalLine = new String[42000];
		int i = 0;
		while (true) {
			String line;
			if ((line = reader.readLine()) == null) {
				break;
			}
			severalLine[i] = line;
			i++;
		}
		for (int j = 31043; j < 35683; j++) {
			String[] Split = severalLine[j].split(",");
			count.add(Integer.parseInt(Split[2]));
			date.add(Split[0]);
			code.add(Split[1]);
		}
		for (int k = 0; k < MonthCount2019(date, count, code).size(); k++) {
			coldcount[k] = MonthCount2019(date, count, code).get(k);
		}
		return coldcount;
	}

	public ArrayList<Integer> MonthCount2019(ArrayList<String> date, ArrayList<Integer> count, ArrayList<String> code) {// 19��
		ArrayList<Integer> monthly = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			int sum = 0;
			for (int k = 0; k < date.size(); k++) {
				if (date.get(k).substring(0, 6).equals("20190" + (i + 1)) && code.get(k).equals("11")) {
					monthly.add(count.get(k));
				} else if (date.get(k).substring(0, 6).equals("2019" + (i + 1)) && code.get(k).equals("11")) {
					monthly.add(count.get(k));
				}
			}
		}
		return monthly;
	}

	// ����.2020.1~9.
	public double[] get_Cold2020() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kopo\\Desktop\\cold.csv"));
		ArrayList<Integer> count = new ArrayList<Integer>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<String> code = new ArrayList<String>();
		double[] coldcount = new double[273];
		String[] severalLine = new String[42000];
		int i = 0;
		while (true) {
			String line;
			if ((line = reader.readLine()) == null) {
				break;
			}
			severalLine[i] = line;
			i++;
		}
		for (int j = 37248; j < 41888; j++) {
			String[] Split = severalLine[j].split(",");
			count.add(Integer.parseInt(Split[2]));
			date.add(Split[0]);
			code.add(Split[1]);
		}
		for (int k = 0; k < MonthCount2020(date, count, code).size(); k++) {
			coldcount[k] = MonthCount2020(date, count, code).get(k);
		}
		return coldcount;
	}

	public ArrayList<Integer> MonthCount2020(ArrayList<String> date, ArrayList<Integer> count, ArrayList<String> code) {// 20��
		ArrayList<Integer> monthly = new ArrayList<Integer>();
		for (int i = 0; i < 9; i++) {
			int sum = 0;
			for (int k = 0; k < date.size(); k++) {
				if (date.get(k).substring(0, 6).equals("20200" + (i + 1)) && code.get(k).equals("11")) {
					monthly.add(count.get(k));
				} else if (date.get(k).substring(0, 6).equals("2020" + (i + 1)) && code.get(k).equals("11")) {
					monthly.add(count.get(k));
				}
			}
		}
		return monthly;
	}

}
