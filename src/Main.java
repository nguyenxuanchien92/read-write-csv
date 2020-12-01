import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "n";

    private static final String FILE_HEADER = "id,code,name";

    public static void main(String[] args) {
        String fileName = "src/countries.csv";
        writeCSVFile(fileName);
        readCSVFile(fileName);
    }

    private static void readCSVFile(String fileName) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            fileReader.rea
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
        try{
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Country e : countries){
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
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
}
