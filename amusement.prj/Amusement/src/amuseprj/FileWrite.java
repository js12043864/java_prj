package amuseprj;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileWrite {

	//파일 작성
	public void profit() {
		try {
			BufferedWriter fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream (ConstValue.address, true),"MS949"));
			for (int i = 0; i < ConstValue.cusInfoArray.size(); i++) {
				CustomerInfo info = ConstValue.cusInfoArray.get(i);
				System.out.println(info);
				fw.write(time() + "," + info.getType() + "," + info.getPerson_Type() + "," + info.getCount() + ","
						+ info.getPrice() + "," + info.getPrior() + "\n");
			}
			
			fw.close();
		} catch (Exception e) {
		}
	}
	
	//날짜 return
	public static String time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String time = format.format(cal.getTime());
		return time;
	}
}
