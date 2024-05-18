import java.util.Scanner;
public class FirstDegreeEquations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter coefficients for the first equation (a11 a12 b1): ");
        double a11 = keyboard.nextDouble();
        double a12 = keyboard.nextDouble();
        double b1 = keyboard.nextDouble();

        System.out.println("Enter coefficients for the second equation (a21 a22 b2): ");
        double a21 = keyboard.nextDouble();
        double a22 = keyboard.nextDouble();
        double b2 = keyboard.nextDouble();
        
        double D = a11 * a22 - a12 * a21;
        double D1 = b1 * a22 - b2 * a12;
        double D2 =a11 * b2 - a21 * b1;

        if (D!= 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The solution are :" + x1 + " and "+ x2);
        }
        else {
            
            if ((a11 / a21) == (a12 / a22) && (a11 / b1) == (a12 / b2)) {
                
                System.out.println("Infinitely many solutions");
            }
            else {
                
                System.out.println("No solution");
            }
           
        }

	}

}
