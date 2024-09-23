package Patterns;
import java.util.Scanner;
public class SolidRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowlen = Integer.parseInt(sc.nextLine());
        int collen = sc.nextInt();

        for (int row = 1; row <= rowlen ; row++) {
            for (int col = 1; col <= collen ; col++) {
                System.out.print("* ");
            }
            System.out.println(" ");

        }

    }
}
