package Exercise01;

//Enter 3 numbers from the user & make a function to print their average.
import java.util.Scanner;

public class Task01 {

    public static int countAvg(int a, int b, int c) {
        return (a + b + c) / 3;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int avg = countAvg(a, b, c);
        System.out.println("The average is " + avg);


    }
}
