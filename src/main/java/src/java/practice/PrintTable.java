package src.java.practice;

public class PrintTable {
	public static void main(String[] args) {
		printTable(3, 1);

	}

	public static int printTable(int num, int count) {
		if(count == 11) {
			return 1;
		}
		
		System.out.println(num * count);
		return printTable(num, count+1);
	}
}
