import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstName = "";

        firstName = SafeInput.getNonZeroLenString(in, "Enter your first name");

        System.out.println("First name is: "+firstName);
    }
}
