package currency;

public class ConstValueClass {
	public static final int CHANGE_TYPE_USD = 1;
	public static final int CHANGE_TYPE_EUR = 2;
	public static final int CHANGE_TYPE_JPY = 3;
	public static final int[] KIND_OF_USD = { 100, 50, 20, 10, 5, 1 };
	public static final int[] KIND_OF_EUR = { 500, 200, 100, 50, 20, 10, 1 };
	public static final int[] KIND_OF_JPY = { 10000, 5000, 2000, 1000 };
	public static final int[] KIND_OF_KOR = { 1000, 500, 100, 50, 10 };
	public static final String[] MONEY_UNIT = { "달러", "유로", "엔" };
	public static final double[] Currency = { 1134.30, 1333.16, 10.30 }; // 달러,유로,엔 환율
	public static final double[] BALANCE = { 500, 500, 5000 }; // 달러,유로,엔 잔액
}
