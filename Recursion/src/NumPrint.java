import java.util.Scanner;
public class NumPrint {

    public static void printNumRev(int n){
        if (n == 0){
            return;
        }
        System.out.println(n);
        printNumRev(n-1);
    }

    public static void printNum(int s, int n){
        if (s == n){
            return;
        }
        System.out.println(s);
        printNum(s + 1, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        printNumRev(n);
        printNum(s,n);
    }
}
