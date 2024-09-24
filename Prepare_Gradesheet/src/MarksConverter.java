import java.util.Scanner;

public class MarksConverter {
    public static double convertMarks(double marksOutOf20) {
        double marksOutOf25 = (marksOutOf20 / 20) * 25;
        marksOutOf25 = Math.round(marksOutOf25 * 100.0) / 100.0;

        return marksOutOf25;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total Students: ");
        int students = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= students ; i++) {
            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            System.out.print("Converted marks: " + convertMarks(marks) + "\n");
        }

    }
}
