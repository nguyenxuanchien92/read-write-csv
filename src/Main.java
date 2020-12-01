import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    private static final String FILE_HEADER = "id,code,name";

    public static void main(String[] args) {
        String fileName = "src/countries.csv";
        writeCSVFile(fileName);
        readCSVFile(fileName);
    }

    private static void readCSVFile(String fileName) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            String line = null;
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                printCountry(parseCsvLine(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }

        return result;
    }

    private static void printCountry(List<String> countries) {
        System.out.println(
                "Country [id= "
                        + countries.get(0)
                        + ", code= " + countries.get(1)
                        + " , name= " + countries.get(2)
                        + "]");
    }

    private static void writeCSVFile(String fileName) {
        Country country1 = new Country(1, "US", "United States");
        Country country2 = new Country(2, "VN", "Viet Nam");
        Country country3 = new Country(3, "AU", "Australia");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Country e : countries) {
                fileWriter.append(String.valueOf(e.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(e.getCode());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(e.getName());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
