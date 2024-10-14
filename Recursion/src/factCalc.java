import java.util.Scanner;
public class factCalc {

    public static int calcFactorial(int n) {
        if(n==0 || n==1){
            return 1;
        }
        return n * calcFactorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int fact = calcFactorial(num);
        System.out.println("The factorial of " + num + " is " + fact);
    }
}
