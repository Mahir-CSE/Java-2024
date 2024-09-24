package Exercise01;
// Write a function that takes in the radius as input and returns the circumference of a circle.

import java.util.Scanner;

public class Task04 {
    public static double calcCircum(int r){
        return 2 * Math.PI * r;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        double result = calcCircum(r);
        System.out.println(result);

    }
}
