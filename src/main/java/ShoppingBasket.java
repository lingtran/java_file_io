import java.util.ArrayList;

public class ShoppingBasket {
    private Double salesTaxes;
    private Double total;
    private ArrayList<Item> basketOfItems;

    public Double getSalesTaxes() {
        return salesTaxes;
    }

    public void setSalesTaxes(Double salesTaxes) {
        this.salesTaxes = salesTaxes;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public ArrayList<Item> getBasketOfItems() {
        return basketOfItems;
    }

    public void setBasketOfItems(ArrayList<Item> basketOfItems) {
        this.basketOfItems = basketOfItems;
    }

    public ShoppingBasket() {
        setSalesTaxes(0.0);
        setTotal(0.0);
        setBasketOfItems(new ArrayList<Item>());
    }
}
