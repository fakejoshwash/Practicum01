import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean doneInput = false;
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        String rec = "";
        int YOB = 0;
        ArrayList <String> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter your ID (xxxxxx)");
            firstName = SafeInput.getNonZeroLenString(in, "Please enter your first name");
            lastName = SafeInput.getNonZeroLenString(in, "Please enter your last name");
            title = SafeInput.getNonZeroLenString(in, "Please enter your title (Mr., Ms., Dr., etc.)");
            YOB = SafeInput.getRangedInt(in, "Please enter your year of birth", 1000, 9999);
            rec = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
            System.out.println(rec);
            people.add(rec);
            doneInput = SafeInput.getYNConfirm(in, "Are you done? (Y/N)");
        } while(!doneInput);
    }
}
