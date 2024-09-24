package Exercise01;
//Write a program to enter the numbers till the user wants and at the end it should display the count of positive, negative and zeros entered.
import java.util.Scanner;
public class Task07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = Integer.parseInt(sc.nextLine());
        int pos = 0;
        int neg = 0;
        int zeros = 0;
        for (int i = 1; i <= nums ; i++) {
            int num = Integer.parseInt(sc.nextLine());
            if(num>0){
                pos = pos + 1;
            }
            else if(num<0){
                neg = neg + 1;
            }
            else{
                zeros = zeros + 1;
            }

        }
        System.out.println(pos);
        System.out.println(neg);
        System.out.println(zeros);
    }

}
