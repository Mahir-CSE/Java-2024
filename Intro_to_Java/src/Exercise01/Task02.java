package Exercise01;
//Write a function to print the sum of all odd numbers from 1 to n.

import java.util.Scanner;

public class Task02 {

    public static int sumCount(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if(i%2 == 1){
                sum += i;
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int result = sumCount(n);
        System.out.println(result);


    }
}
