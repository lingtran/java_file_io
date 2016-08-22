import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.File;
import java.util.ArrayList;

import static java.nio.file.Paths.get;


public class FileHandler {
    public static void main(String[] args) {

    }

    public FileHandler() {

    }

    public String readFile(String filepath) throws FileNotFoundException, URISyntaxException {
        String line = null;
        ArrayList<String> readLines = new ArrayList<String>();

        try {
            FileReader inFile  =  new FileReader(new File(filepath).getAbsoluteFile());
            System.out.println(inFile);

            BufferedReader buffer = new BufferedReader(inFile);

            while((line = buffer.readLine()) != null) {
                readLines.add(line);
                System.out.println("Read line: " + line);
            }

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully read file");
        return readLines.toString();
    }
}
