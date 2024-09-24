package Strings;

public class CoreStrings {
    public static void main(String[] args) {
        String firstName = "Mahir";
        String lastName = "Ahmed";

        // Concatenation
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        // length of the String
        System.out.println("Length of fullName: " + fullName.length());

        //charAt(index)
        System.out.println(fullName.charAt(4));

        //substring
        String sub = fullName.substring(3,9);
        System.out.println(sub);


    }
}
