package Regression;
import java.io.IOException;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
public class Main {
	public static void main(String[] args) throws IOException {
		MultiRegressionUtils main = new MultiRegressionUtils();
		PrintResults pr = new PrintResults();
		Calculator cal = new Calculator();
		X_Axis_Calculator xAxisCal = new X_Axis_Calculator();
		Y_Axis_Calculator yAxisCal = new Y_Axis_Calculator();
		
		OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
		String[] xName = {"��ձ��", "�̼�����"}; // "�����µ�", "����", "�ϱ���", "ȯ����", "�ڷγ�";
		
		// names of elements on X-axis
		/*
		double[][] X = new double[][]{{5000,0.5,8},{4000,2,6},{3500,1,5},{3500,2.5,4},{5100,1.5,7},
			 {4000,1,6},{3200,2,5},{3700,1.25,6},{3000,2,5,},{2900,3,4},{2900,1,5},
			 {3200,2,8},{4300,1.25,7},{2900,3,4}}; 
		double[] Y = new double[]{9,4,6,3,7,8,5,7,4,3,6,7,8,4};
		*/
				
		// make X-axis elements(monthly)
		double[][] X = new double[12][2];
		for(int i = 0; i < 12; i++) {
			//X[i][0] = xAxisCal.get_Temp_TwoYearCompare()[i];
			//X[i][1] = xAxisCal.get_Corona()[i];
			//X[i][0] = cal.get_Monthly(xAxisCal.get_Il_Temp())[i];
			//X[i][0] = cal.get_Monthly(xAxisCal.get_Season())[i];
			//X[i][0] = cal.get_Monthly(xAxisCal.get_Temp())[i];
			//X[i][1] = xAxisCal.get_Dust()[i];
			//X[i][0] = cal.get_Monthly(xAxisCal.get_Low())[i];
			//X[i][0] = xAxisCal.get_Temp()[i];
			//X[i][1] = xAxisCal.get_Il_Temp()[i];
			//X[i][2] = xAxisCal.get_Season()[i];
		}
		
		// make Y-axis elements(monthly)
		double[] Y = cal.get_Monthly(yAxisCal.get_Cold());
		

		System.out.println("------------]---------------");
//		double[] Y = new double[18];								//�ڷγ� ���� ���� �� ��� (18���� �迭 ��Ҹ� ���)
//		for(int i = 0; i < 9; i++) {
//			Y[i] = cal.get_9Monthly(yAxisCal.get_Cold2019())[i];
//		}
//		
//		for(int i = 9; i < 18; i++) {
//			Y[i] = cal.get_9Monthly_29(yAxisCal.get_Cold2020())[i-9];
//		}

		
		// set regression sample
		regression.newSampleData(Y, X);

		// set rsq, p-value, coefficient, vif(���߰�����)
		double[] rsq =main.RSquare(regression);
		double[] pValue = main.getPValue(regression);
		double[] coefficient = main.coefficient(regression);
		double[] vif = main.getVIF(regression, X);
		
		// print regression sample
		pr.printRSquare(rsq);
		pr.printIndependentsResult(pValue, coefficient, vif, xName);
	}
}
