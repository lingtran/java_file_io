import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class FileHandler {
    Processor processor;

    public static FileHandler main(String filepath) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.readFile(filepath);
        return fileHandler;
    }

    public FileHandler() {
        processor = new Processor();
    }

    public String readFile(String filepath) {
        String line = null;

        try {
            FileReader inFile  =  new FileReader(new File(filepath).getAbsoluteFile());
            System.out.println(inFile);

            BufferedReader buffer = new BufferedReader(inFile);

            convertLines(line, buffer, processor);

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully read file");
        return  "Successfully read file";
    }

    private static void convertLines(String line, BufferedReader buffer, Processor processor) throws IOException {
        // for debugging purposes
        ArrayList<String> readLines = new ArrayList<String>();

        while((line = buffer.readLine()) != null) {
            processor.addItemToBasket(Parser.parseItem(line));

            // for debugging
            readLines.add(line);
            System.out.println("Read line: " + line);
        }
    }
}
