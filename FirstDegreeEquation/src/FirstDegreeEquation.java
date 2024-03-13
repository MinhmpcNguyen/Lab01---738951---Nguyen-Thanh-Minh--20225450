import java.util.Scanner;
public class FirstDegreeEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		double a = keyboard.nextDouble();
		double b = keyboard.nextDouble();
		double c = keyboard.nextDouble();
		if (a==0) {
			System.out.println("Infinity");
		}
		else {
			double x = (c-b)/a;
			System.out.println("The solution is: " + x);
		}
		

	}

}
