public class SalesTaxCalculator {
    private static final Double BASICSALESTAX = 0.1;
    private static final Double IMPORTDUTY    = 0.05;

    public static void calculate(ShoppingBasket shoppingBasket) {
        for (Item item : shoppingBasket.getBasketOfItems()) {
            calculateItemTaxesAndTotal(item);
            calculateBasketTaxesAndTotal(shoppingBasket, item.getSalesTax(), item.getTotal());
        }
    }

    private static void calculateBasketTaxesAndTotal(ShoppingBasket shoppingBasket, Double itemSalesTax, Double itemTotal) {
        Double currentSalesTaxes = shoppingBasket.getSalesTaxes();
        Double currentTotal      = shoppingBasket.getTotal();

        shoppingBasket.setSalesTaxes(roundUpSalesTax(currentSalesTaxes += itemSalesTax));
        shoppingBasket.setTotal(currentTotal += itemTotal);
    }

    private static void calculateItemTaxesAndTotal(Item item) {
        determineItemBasicSalesTax(item);
        determineItemImportDuty(item);
        item.setTotal(item.getTotal() + item.getSalesTax());
    }


    public static void determineItemBasicSalesTax(Item item) {
        if (!item.isExemptStatus()) {
            item.setSalesTax(item.getSalesTax() + (BASICSALESTAX * item.getPrice()));
        }
        item.setSalesTax(roundUpSalesTax(item.getSalesTax()));
    }

    public static void determineItemImportDuty(Item item) {
        if (item.isImportStatus()) {
            item.setSalesTax(item.getSalesTax() + (IMPORTDUTY * item.getPrice()));
        }
        item.setSalesTax(roundUpSalesTax(item.getSalesTax()));
    }

    public static Double roundUpSalesTax(Double determinedSalesTax) {
        return Math.ceil(determinedSalesTax * 20) / 20.0;
    }
}
