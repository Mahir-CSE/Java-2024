package Conditional_Statements;

import java.util.Scanner;

public class TestSwitch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Pick a day: ");
        String day = sc.nextLine();

        switch(day){
            case "Monday":
                System.out.println("CSE110 class");
                break;
            case "Tuesday":
                System.out.println("CSE220 class");
                break;
            case "Wednesday":
                System.out.println("CSE320 class");
                break;
            case "Thursday":
                System.out.println("CSE420 class");
                break;
            case "Friday":
                System.out.println("Weekend");
                break;
            case "Saturday":
                System.out.println("Rest day");
                break;
            case "Sunday":
                System.out.println("Week Starts with PYHSICS");
                break;

            default:
                System.out.println("Invalid day");

        }

    }
}
