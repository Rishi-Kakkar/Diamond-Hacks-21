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
        String[] individualCompanies = CompanyKey.split(",");
        String[] individualPositions = PositionKey.split(",");
        try {
            File myObj = new File("files/JobListings.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                for (String i : individualCompanies) {
                    for (String j : individualPositions) {
                        if (data.contains(i) && data.contains(j)) {
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
        String[] breakdown = new String[2];
        String[] cResult = new String[results.size()];
        int counter = 0;
        for (String i : results) {
            breakdown = i.split("-", 2);
            cResult[counter] = breakdown[0];
        }
        return cResult;
    }

    public String[] PositionResult(List<String> results) {
        String[] breakdown = new String[2];
        String[] pResult = new String[results.size()];
        int counter = 0;
        for (String i : results) {
            breakdown = i.split("-", 2);
            pResult[counter] = breakdown[1];
        }
        return pResult;
    }
}
