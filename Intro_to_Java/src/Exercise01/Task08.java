package Exercise01;
//Two numbers are entered by the user, x and n. Write a function to find the value of one number raised to the power of another i.e. x^n
import java.util.Scanner;
public class Task08 {
    public static void calcPow(int a, int b){
        double result = Math.pow(a,b);
        System.out.println(result);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());

        calcPow(x, n);

    }
}
