import java.util.Scanner;
public class calculate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		double num1 = keyboard.nextDouble();
		double num2 = keyboard.nextDouble();
		double sumNum= num1 + num2;
		System.out.println("The sum is: "+ sumNum);
		if (num1>num2) {
			double diffNum =num1-num2;
			System.out.println("The difference is: "+ diffNum);
			
		}
		else {
			double diffNum=num2-num1;
			System.out.println("The difference is: "+ diffNum);
		}
		double multiNum=num1*num2;
		System.out.println("The product is: "+ multiNum);
		if (num1==0&&num2!=0) {
			double divNum= 0;
			System.out.println("num1 divide to num2 is : "+ divNum);
			System.out.println("num2 divide to num1 is : error ");
		}
		if (num1!=0&&num2==0) {
			double divNum= 0;
			System.out.println("num2 divide to num1 is : " +divNum);
			System.out.println("num1 divide to num2 is : error");
		}
		if (num1==0&&num2==0) {
			System.out.println("num1 divide to num2 is : error");
			System.out.println("num2 divide to num1 is : error");
			
		}
		if (num1!=0&&num2!=0) {
			double divNum1 = num1/num2;
			System.out.println("num1 divide to num2 is : "+ divNum1);
			double divNum2 = num2/num1;
			System.out.println("num2 divide to num1 is : "+ divNum2);
		}
		
		

	}

}
