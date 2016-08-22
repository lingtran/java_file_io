import java.io.IOException;

public class Application {
    public static String receipt;
    private static FileHandler fileHandler;
    private static Processor processor;

    public static void main(String[] args) throws IOException {
        initiateFileHandler(args[0]);
        getProcessor();
        processorStartsCalculator();
        processorPrintsReceipt();
        System.out.println("Successfully printed receipt! Check the 'sales_taxes_java/receipts' directory for the most recent output.");

    }

    private static void initiateFileHandler(String filepath) throws IOException {
        fileHandler = FileHandler.main(filepath);
        System.out.println("Hooray! Successfully read file.");
    }

    private static void getProcessor() {
        processor = fileHandler.processor;
    }

    private static void processorStartsCalculator() {
        System.out.println("Your shopping basket is being processed.");
        processor.callSalesTaxCalculator();
    }

    private static String processorPrintsReceipt() throws IOException {
        System.out.println("Receipt is printing...");
        return receipt = processor.getReceipt();
    }

}
