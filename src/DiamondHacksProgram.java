import java.awt.*;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.util.List;

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

    public List<String> Keyword(String CompanyKey, String PositionKey) {
        List<String> results = new ArrayList<String>();
        String[] individualCompanies = CompanyKey.toLowerCase().split(",");
        String[] individualPositions = PositionKey.toLowerCase().split(",");
        try {
            File myObj = new File("files/JobListings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (String i : individualCompanies) {
                    for (String j : individualPositions) {
                        if (data.toLowerCase().contains(i) && data.toLowerCase().contains(j)) {
                            results.add(data);
                        }
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

    public String[] CompanyResult(List<String> results) {
        String[] cResult = new String[results.size()];
        int counter = 0;
        for (String i : results) {
            String[] breakdown = i.split("-", 2);
            cResult[counter] = breakdown[0];
            counter++;
        }
        return cResult;
    }

    public String[] PositionResult(List<String> results) {
        String[] pResult = new String[results.size()];
        int counter = 0;
        for (String i : results) {
            String[] breakdown = i.split(" - ", 2);
            pResult[counter] = breakdown[1];
            counter++;
        }
        return pResult;
    }
}
