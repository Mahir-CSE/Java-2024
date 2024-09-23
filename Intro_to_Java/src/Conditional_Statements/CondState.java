package Conditional_Statements;

import java.util.Scanner;
public class CondState {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter age: ");
        float age = sc.nextFloat();

        if(age>=18){
            System.out.println("Adult");
        }
        else if (age <18 && age >= 10){
            System.out.println("Child");
        }
        else{
            System.out.println(" 0 - 9 years old");
        }

    }
}
