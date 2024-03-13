import java.util.Scanner;

public class DaysOfMonth {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        int month = 0;
        int year;
        
        
        System.out.print("Enter the year : ");
        year = keyboard.nextInt();
        
        
        System.out.print("Enter the month : ");
        String mon = keyboard.next();

        
        int a = 0;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            a = 1;
        } else {
            a = 2;
        }
        
        // Determine the month number
        switch (mon) {
            case "January":
            case "Jan":
            case "Jan.":
            case "1":
                month = 1;
                break;
            case "February":
            case "Feb":
            case "Feb.":
            case "2":
                month = 2;
                break;
            case "March":
            case "Mar":
            case "Mar.":
            case "3":
                month = 3;
                break;
            case "April":
            case "Apr":
            case "Apr.":
            case "4":
                month = 4;
                break;
            case "May":
            case "May.":
            case "5":
                month = 5;
                break;
            case "June":
            case "Jun":
            case "Jun.":
            case "6":
                month = 6;
                break;
            case "July":
            case "Jul":
            case "Jul.":
            case "7":
                month = 7;
                break;
            case "August":
            case "Aug":
            case "Aug.":
            case "8":
                month = 8;
                break;
            case "September":
            case "Sep":
            case "Sep.":
            case "9":
                month = 9;
                break;
            case "October":
            case "Oct":
            case "Oct.":
            case "10":
                month = 10;
                break;
            case "November":
            case "Nov":
            case "Nov.":
            case "11":
                month = 11;
                break;
            case "December":
            case "Dec":
            case "Dec.":
            case "12":
                month = 12;
                break;
            default:
                System.out.println("Invalid month. Please enter a valid month.");
        }
        
        // Determine the number of days in the month
        int days = 0;
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;
            case 4: case 6: case 9: case 11:
                days = 30;
                break;
            case 2:
                if (a == 1) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            default:
                System.out.println("Invalid month. Please enter a valid month.");
        }

        // Print the number of days in the month
        System.out.println("The number of days: " + days);
        
        
    }
}
