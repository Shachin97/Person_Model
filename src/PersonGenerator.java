import java.util.ArrayList;
import java.util.Scanner;


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








    }

}
