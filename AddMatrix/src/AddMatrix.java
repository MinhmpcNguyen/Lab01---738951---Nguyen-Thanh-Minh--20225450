import java.util.Scanner;
public class AddMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int m = keyboard.nextInt();
		int n = keyboard.nextInt();
		int [][]arr1 = new int [m][n];
		int [][]arr2 = new int [m][n];
		int [][]arr3 = new int [m][n];
		for(int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				arr1[i][j]= keyboard.nextInt();			
				}
		}
		for(int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				arr2[i][j]= keyboard.nextInt();			
				}
		}
		for(int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				arr3[i][j]= arr1[i][j]+arr2[i][j];			
				}
		}
		for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr3[i][j] + "\t"); // Use "\t" for space between numbers
            }
            System.out.println();
            System.out.println();
        }
		
		

	}

}
