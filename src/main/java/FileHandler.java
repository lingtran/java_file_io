import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
    Processor processor;

    public FileHandler() {
        processor = new Processor();
    }

    public static FileHandler main(String filepath) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.readFile(filepath);
        return fileHandler;
    }

    private static void convertLines(BufferedReader buffer, Processor processor) throws IOException {
        String line;
        while ((line = buffer.readLine()) != null) {
            processor.addItemToBasket(Parser.parseItem(line));
        }
    }

    public String readFile(String filepath) {
        try {
            FileReader inFile     = new FileReader(new File(filepath).getAbsoluteFile());
            BufferedReader buffer = new BufferedReader(inFile);

            convertLines(buffer, processor);
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Successfully read file";
    }
}
