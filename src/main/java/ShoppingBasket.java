import java.util.ArrayList;

public class ShoppingBasket {
    Double salesTaxes;
    Double total;
    ArrayList<Item> basketOfItems;

    public static void main(String[] arg) {

    }

    public ShoppingBasket() {
        salesTaxes	  = 0.0;
        total		  = 0.0;
        basketOfItems = new ArrayList<Item>();
    }

}
