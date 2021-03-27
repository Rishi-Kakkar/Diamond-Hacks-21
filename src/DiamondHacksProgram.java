import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiamondHacksProgram {

    public void ReadFile() {
        try {
            File myObj = new File("files/JobListings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<String> Keyword(String key) {
        List<String> results = new ArrayList<String>();
        String[] individualCompanies = key.split(",");
        try {
            File myObj = new File("files/JobListings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (String i : individualCompanies) {
                    if (data.contains(i)) {
                        results.add(data);
                    }
                }
            }
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return results;
    }
}
