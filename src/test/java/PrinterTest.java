import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrinterTest {

    @Test
    public void testFormatItemsLines() throws IOException {
        Processor processor	  = new Processor();
        ArrayList<Item> items = processor.getShoppingBasket().getBasketOfItems();
        Item book			  = new Item("1", "book", "12.49");
        Item cd				  = new Item("1", "music CD", "14.99");
        Item choco			  = new Item("1", "chocolate bar", "0.85");
        Printer test		  = new Printer();
        String result		  = "[1 book: 12.49, 1 music CD: 16.49, 1 chocolate bar: 0.85]";

        processor.addItemToBasket(book);
        processor.addItemToBasket(cd);
        processor.addItemToBasket(choco);
        processor.callSalesTaxCalculator();

        test.formatItemsLines(items);

        String lines = test.content.toString();

        assertEquals( result, lines );
    }

    @Test
    public void testFormatSummaryLines() throws IOException {
        Processor processor	  = new Processor();
        ShoppingBasket basket = processor.getShoppingBasket();
        Item book			  = new Item("1", "book", "12.49");
        Item cd				  = new Item("1", "music CD", "14.99");
        Item choco			  = new Item("1", "chocolate bar", "0.85");
        Printer test		  = new Printer();
        String result		  = "[Sales Taxes: 1.50, Total: 29.83]";

        processor.addItemToBasket(book);
        processor.addItemToBasket(cd);
        processor.addItemToBasket(choco);
        processor.callSalesTaxCalculator();

        test.formatSummaryLines(basket);

        String lines = test.content.toString();

        assertEquals( result, lines );
    }

    @Test
    public void testGatherContentOf() throws IOException {
        Processor processor	  = new Processor();
        ShoppingBasket basket = processor.getShoppingBasket();
        Item book			  = new Item("1", "book", "12.49");
        Item cd				  = new Item("1", "music CD", "14.99");
        Item choco			  = new Item("1", "chocolate bar", "0.85");
        Printer test		  = new Printer();
        String result		  = "[1 book: 12.49, 1 music CD: 16.49, 1 chocolate bar: 0.85, Sales Taxes: 1.50, Total: 29.83]";

        processor.addItemToBasket(book);
        processor.addItemToBasket(cd);
        processor.addItemToBasket(choco);
        processor.callSalesTaxCalculator();

        test.gatherContentOf(basket);

        String lines = test.content.toString();

        assertEquals( result, lines );
    }

    @Test
    public void testWriteReceiptFor() throws IOException {
        Processor processor	  = new Processor();
        ShoppingBasket basket = processor.getShoppingBasket();
        Item book			  = new Item("1", "book", "12.49");
        Item cd				  = new Item("1", "music CD", "14.99");
        Item choco			  = new Item("1", "chocolate bar", "0.85");
        Printer test		  = new Printer();
        File newReceipt  	  = new File(test.receiptFilePath);

        processor.addItemToBasket(book);
        processor.addItemToBasket(cd);
        processor.addItemToBasket(choco);
        processor.callSalesTaxCalculator();

        test.writeReceiptFor(basket);

        assertTrue( newReceipt.exists() );
    }
}