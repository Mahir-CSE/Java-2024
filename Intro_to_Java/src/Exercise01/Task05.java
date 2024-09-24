package Exercise01;
// Write a function that takes in age as input and returns if that person is eligible to vote or not. A person of age > 18 is eligible to vote.
import java.util.Scanner;
public class Task05 {
    public static void checkEligibility(int a){
        if (a > 0) {
            if(a>=18){
                System.out.println("Eligible");
            }
            else{
                System.out.println("Not eligible");
            }
        }
        else{
            System.out.println("Invalid Age");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = Integer.parseInt(sc.nextLine());
        checkEligibility(age);

    }

}
