package Exercise01;
//Write a program to print Fibonacci series of n terms where n is input by user :
//0 1 1 2 3 5 8 13 21 .....
//In the Fibonacci series, a number is the sum of the previous 2 numbers that came before it.

import java.util.Scanner;
public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms for Fibonacci series: ");
        int n = scanner.nextInt();
        int firstTerm = 0, secondTerm = 1;
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
        } else if (n == 1) {
            System.out.println("Fibonacci series: " + firstTerm);
        } else {
            System.out.print("Fibonacci series: " + firstTerm + " " + secondTerm);

            for (int i = 3; i <= n; i++) {
                // Calculate the next term by adding the previous two terms
                int nextTerm = firstTerm + secondTerm;
                System.out.print(" " + nextTerm);

                // Update the terms for the next iteration
                firstTerm = secondTerm;
                secondTerm = nextTerm;
            }
            System.out.println();
        }
        scanner.close();
    }
}

