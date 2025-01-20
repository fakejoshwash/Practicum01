import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {
    public static void main(String[] args) {
        boolean doneInput = false;
        String ID = "";
        String name = "";
        String description = "";
        String rec = "";
        double cost = 0;
        ArrayList<String> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter ID (six digits, eg '123456')");
            name = SafeInput.getNonZeroLenString(in, "Please enter name");
            description = SafeInput.getNonZeroLenString(in, "Please enter description");
            cost = SafeInput.getRangedDouble(in, "Please enter price", 0, 9999);
            rec = ID + ", " + name + ", " + description + ", " + cost;
            System.out.println(rec);
            people.add(rec);
            doneInput = SafeInput.getYNConfirm(in, "Are you done? (Y/N)");
        } while(!doneInput);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String person : people) {
                writer.write(person, 0, person.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data written to file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
