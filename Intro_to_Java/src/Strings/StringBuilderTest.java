package Strings;

public class StringBuilderTest {
    public static void main(String[] args) {
        //String builder creation
        StringBuilder s1 = new StringBuilder("Mahir");
        System.out.println(s1);

        //chatAt
        System.out.println(s1.charAt(2));

        //setCharAt (index, char)
        s1.setCharAt(3, 'e');
        System.out.println(s1);

        //insert(index, char)
        s1.insert(4, 'e');
        System.out.println(s1);

        //append
        s1.append(" Ahmed");
        System.out.println(s1);

        //delete (start, end)
        s1.delete(6,s1.length());
        System.out.println(s1);
    }
}
