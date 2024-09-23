package Loops;

public class LoopsBasics {
    public static void main(String[] args) {
        System.out.print("For Loop output: ");
        for(int i = 0; i < 10; i++) {
            System.out.print(i + ", ");

        }
        System.out.println();

        int j = 0;

        System.out.print("While Loop output: ");
        while(j < 10) {
            System.out.print(j + ",");
            j++;
        }
        System.out.println();

        System.out.print("DO-WHILE Output: ");
        do{
            System.out.print(j + ",");
            j++;
        }while(j < 10);
    }

}
