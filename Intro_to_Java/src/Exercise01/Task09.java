package Exercise01;
//Write a function that calculates the Greatest Common Divisor of 2 numbers. (BONUS)

public class Task09 {

        // Function to calculate the GCD of two numbers
        public static int gcd(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        public static void main(String[] args) {
            int num1 = 24;
            int num2 = 36;

            int result = gcd(num1, num2);
            System.out.println("GCD of " + num1 + " and " + num2 + " is: " + result);
        }
    }

