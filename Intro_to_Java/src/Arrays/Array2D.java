package Arrays;

import java.util.Scanner;

public class Array2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];

        //Adding values in 2D array
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }

        }

        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();

        }

        int val = sc.nextInt();
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j] == val ){
                    System.out.println("Index value: "+ " ("+ i + "," + j + ") ");
                    break;
                }
            }

        }
    }
}
