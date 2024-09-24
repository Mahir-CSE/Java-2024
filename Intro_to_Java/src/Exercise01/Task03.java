package Exercise01;
//Write a function which takes in 2 numbers and returns the greater of those two.
import java.util.Scanner;

public class Task03 {

    public static int findGreat(int a, int b){
        return Math.max(a, b);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int result = findGreat(n1, n2);
        System.out.println("Greater Number: "+result);


    }
}
