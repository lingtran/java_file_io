import java.io.IOException;
import java.util.ArrayList;

public class Processor {
    ShoppingBasket shoppingBasket;
    ArrayList<Item> items;

    public Processor() {
        shoppingBasket = new ShoppingBasket();
        items          = shoppingBasket.basketOfItems;
    }

    public ArrayList<Item> addItemToBasket(Item item) {
        items.add(item);
        return items;
    }

    public void callSalesTaxCalculator() {
        SalesTaxCalculator.main(shoppingBasket);
    }

    public String getReceipt() throws IOException {
        Printer printer = new Printer();
        printer.writeReceiptFor(shoppingBasket);
        return printer.receiptFilePath;
    }
}