package variables_and_datatypes;

import java.util.Scanner;

public class VarDtype {

    public static void main(String[] args) {
        String name = "Mahir";
        int a = 20;
        float b = 15.75f;
        boolean c = true;
        double d = 16.7846546;
        byte e = 16;
        short f = 264;
        long g = 2644;
        int h[] = {2,4,6};

        // USER INPUT
        Scanner sc = new Scanner(System.in);
        String n1 = sc.nextLine();
        int n2 = sc.nextInt();
        float n3 = sc.nextFloat();

        System.out.println("Name: "+ name + "\nId: "+ n2 + "\nAge: " + n3 );

    }

}
