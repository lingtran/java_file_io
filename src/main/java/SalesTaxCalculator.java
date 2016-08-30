public class SalesTaxCalculator {
    private static final Double BASICSALESTAX = 0.1;
    private static final Double IMPORTDUTY    = 0.05;

    public static void calculate(ShoppingBasket shoppingBasket) {
        for (Item item : shoppingBasket.basketOfItems) {
            calculateItemTaxesAndTotal(item);
            calculateBasketTaxesAndTotal(shoppingBasket, item.salesTax, item.total);
        }
    }

    private static void calculateBasketTaxesAndTotal(ShoppingBasket shoppingBasket, Double itemSalesTax, Double itemTotal) {
        shoppingBasket.salesTaxes = roundUpSalesTax(shoppingBasket.salesTaxes += itemSalesTax);
        shoppingBasket.total += itemTotal;
    }

    private static void calculateItemTaxesAndTotal(Item item) {
        determineItemBasicSalesTax(item);
        determineItemImportDuty(item);
        item.total += item.salesTax;
    }


    public static Double determineItemBasicSalesTax(Item item) {
        if (!item.exemptionStatus) {
            item.salesTax += (BASICSALESTAX * item.price);
        }
        return item.salesTax = roundUpSalesTax(item.salesTax);
    }

    public static Double determineItemImportDuty(Item item) {
        if (item.importStatus) {
            item.salesTax += (IMPORTDUTY * item.price);
        }
        return item.salesTax = roundUpSalesTax(item.salesTax);
    }

    public static Double roundUpSalesTax(Double determinedSalesTax) {
        return Math.ceil(determinedSalesTax * 20) / 20.0;
    }
}
