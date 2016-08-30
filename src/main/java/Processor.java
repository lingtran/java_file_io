import java.io.IOException;
import java.util.ArrayList;

public class Processor {
    private ShoppingBasket shoppingBasket;

    public Processor() {
        setShoppingBasket(new ShoppingBasket());
    }

    public ArrayList<Item> addItemToBasket(Item item) {
        getShoppingBasket().getBasketOfItems().add(item);
        return getShoppingBasket().getBasketOfItems();
    }

    public void callSalesTaxCalculator() {
        SalesTaxCalculator.calculate(getShoppingBasket());
    }

    public String getReceipt() throws IOException {
        Printer printer = new Printer();
        printer.writeReceiptFor(getShoppingBasket());
        return printer.receiptFilePath;
    }

    public ShoppingBasket getShoppingBasket() {
        return shoppingBasket;
    }

    public void setShoppingBasket(ShoppingBasket shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }
}