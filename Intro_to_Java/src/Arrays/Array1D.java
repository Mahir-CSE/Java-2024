package Arrays;
import java.util.Scanner;
public class Array1D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size];

        // Adding values in the array
        for (int i = 0; i <= arr.length - 1 ; i++) {
            arr[i] = sc.nextInt();
        }

        // Printing Values of array
        for (int i = 0; i <= arr.length - 1 ; i++) {
            System.out.print(arr[i] + ", ");

        }

        System.out.print("Enter a value: ");
        int val = sc.nextInt();
        // finding an element in an array
        for (int i = 0; i <= arr.length - 1 ; i++) {
            if(arr[i] == val){
                System.out.print("\nThe index of "+ val + "i s: "+ i);
                break;
            }

        }

    }
}
