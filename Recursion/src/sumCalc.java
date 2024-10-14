import java.util.Scanner;


public class sumCalc {

    public static void printSum(int s, int n, int sum){
        if (s == n){
            sum = sum + s;
            System.out.println(sum);
            return;
        }
        sum = sum + s;
        printSum(s+1 , n, sum);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int sum = 0;
        printSum(s, n, sum);



    }
}
