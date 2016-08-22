import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Printer {
    String receiptFilePath;
    ArrayList<String> content;
    private File receipt;
    private FileWriter writeReceipt;
    private BufferedWriter bufferedWriter;

    private static String getDateTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd_hh:mm:ss");
        return df.format(new Date());
    }

    public Printer()  throws IOException  {
        content = new ArrayList<String>();
        setUp();
    }

    public String writeReceiptFor (ShoppingBasket shoppingBasket) throws IOException {
        gatherContentOf(shoppingBasket);
        checkForExistingReceipt();

        try {
            writeLines();
            closeOut();
        }
        catch(IOException e) {
            System.out.println("Error writing to file '" + receiptFilePath + "'" );
            e.printStackTrace();
        }

        System.out.println("Successfully printed receipt. Check the 'sales_taxes_java/receipts' directory for the most recent output.");
        return "Successfully printed receipt";
    }

    private void setUp() throws IOException {
        receiptFilePath = "receipts/receipt_" + getDateTime() + ".txt";
        receipt		   	= new File(receiptFilePath);
        writeReceipt   	= new FileWriter(receipt.getAbsoluteFile(), true);
        bufferedWriter 	= new BufferedWriter(writeReceipt);
    }

    private void closeOut() throws IOException {
        bufferedWriter.close();
        writeReceipt.close();
    }

    public void gatherContentOf(ShoppingBasket shoppingBasket) {
        formatItemsLines(shoppingBasket.basketOfItems);
        formatSummaryLines(shoppingBasket);
    }

    private void checkForExistingReceipt() throws IOException {
        if (!receipt.exists()) {
            receipt.createNewFile();
        }
    }

    public void formatItemsLines(ArrayList<Item> items) {
        for(Item item: items) {
            content.add( String.format("%d %s: %.2f", item.quantity, item.name, item.total) );
        }
    }

    public void formatSummaryLines(ShoppingBasket basket) {
        content.add( String.format("Sales Taxes: %.2f", basket.salesTaxes) );
        content.add( String.format("Total: %.2f", basket.total) );
    }

    private void writeLines() throws IOException {
        for (int i = 0; i < content.size(); i++) {
            bufferedWriter.write(content.get(i));
            bufferedWriter.newLine();
        }
    }
}
