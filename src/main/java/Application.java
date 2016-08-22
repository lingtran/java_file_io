
import java.io.IOException;

public class Application {
    private static FileHandler fileHandler;
    private static Processor processor;
    public static String receipt;

    public static void main(String[] args) throws IOException {
        initiateFileHandler(args[0]);
        getProcessor();
        processorStartsCalculator();
        processorPrintsReceipt();
    }

    private static void initiateFileHandler(String filepath) throws IOException {
        fileHandler = FileHandler.main(filepath);
    }

    private static void getProcessor() {
        processor = fileHandler.processor;
    }

    private static void processorStartsCalculator() {
        processor.callSalesTaxCalculator();
    }

    private static String processorPrintsReceipt() throws IOException {
        return receipt = processor.getReceipt();
    }

}
