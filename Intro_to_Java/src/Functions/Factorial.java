package Functions;

import java.util.Scanner;

public class Factorial {

    public static int factCalc(int num) {
        int fact = 1;
        if (num < 0) {
            throw new IllegalArgumentException("The given number is not a positive number");
        } else {
            for (int i = num; i >= 1; i--) {
                fact = fact * i;


            }
            return fact;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int fact = factCalc(num);
        System.out.println("Factorial of " + num + " is " + fact);


    }
}
