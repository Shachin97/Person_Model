import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;


public class PersonGenerator {
    public static void main(String[] args)
    {
        ArrayList<String> personCSVData = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title= "";
        int dateOfBirth = 0;
        String CSV = "";

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");
        boolean done = false;
        do
        {
           ID = SafeInput.getNonZeroLenString(in, "Enter the ID Number");
           firstName = SafeInput.getNonZeroLenString(in, "Enter the first Name");
           lastName = SafeInput.getNonZeroLenString(in, "Enter the last name");
           title = SafeInput.getNonZeroLenString(in, "Enter the title ");
           dateOfBirth = SafeInput.getRangedInt(in, "Enter the Date of Birth", 1000, 9999);

           CSV = ID +", " + firstName +", " + lastName+", " + title +", " +dateOfBirth;
           personCSVData.add (CSV);
           done = SafeInput.getYNConfirm(in, "Are you done entering");


        }
        while(!done);
        for(String p:personCSVData)
            System.out.println(p);

        try
        {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));



            for(String rec : personCSVData)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line
            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }

}
