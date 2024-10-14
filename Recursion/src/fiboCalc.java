import java.util.Scanner;
public class fiboCalc {
    public static void fibonacci(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b;
        System.out.println(c);
        fibonacci(b, c, n-1);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(a);
        System.out.println(b);
        fibonacci(a, b, n);
    }
}
