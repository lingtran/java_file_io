import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
        try {
            FileReader inFile     =  new FileReader(new File(filepath).getAbsoluteFile());
            BufferedReader buffer = new BufferedReader(inFile);

            convertLines(buffer, processor);

            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully read file");
        return  "Successfully read file";
    }

    private static void convertLines(BufferedReader buffer, Processor processor) throws IOException {
        String line;
        while((line = buffer.readLine()) != null) {
            processor.addItemToBasket(Parser.parseItem(line));
        }
    }
}
