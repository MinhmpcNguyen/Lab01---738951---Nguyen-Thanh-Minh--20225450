import java.util.Scanner;
public class SecondDegreeEquation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);

        // Input coefficients of the quadratic equation
        System.out.println("Enter the coefficients of the quadratic equation (a, b, c):");
        double a = keyboard.nextDouble();
        double b = keyboard.nextDouble();
        double c = keyboard.nextDouble();
        
        double discriminant = b * b - 4 * a * c;
        double delta1 = -b +Math.sqrt(discriminant);
        double delta2 =-b -Math.sqrt(discriminant);
        
        if (a == 0) {
            if (b==0) {
            	System.out.println("Infinity");
            }
            else {
            	double x = -c/b;
            	System.out.println("The one real root is: " +x);
            }
            
        } else if (discriminant > 0) {
            double x1 = delta1 / (2*a);
            double x2 = delta2 /(2*a);
            System.out.println("Real roots are: "+ x1 +" and "+ x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.println("The one real root is: " +x);
            
        } else {
            System.out.println("No real roots.");
            }
	}    
	}
