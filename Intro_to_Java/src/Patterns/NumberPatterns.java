package Patterns;

public class NumberPatterns {
    public static void main(String[] args) {
        int n =5;

        System.out.println("Half Pyramid with numbers:");
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j);

            }

            System.out.println();
        }
        System.out.println();
        System.out.println("Inverted Half pyramid with numbers:");
        for (int i = n; i >= 1 ; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(j);

            }
            System.out.println();
        }
    }
}
