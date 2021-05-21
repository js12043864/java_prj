package report;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRead {

	public List<List<String>> Report() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(ConstValue.report), "MS949"));
			List<List<String>> list = new ArrayList<List<String>>();
			List<String> OneLine = new ArrayList<String>();
			String line = "";
			while ((line = reader.readLine()) != null) {
				String[] array = line.split(",");
				OneLine = Arrays.asList(array);
				list.add(OneLine);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

