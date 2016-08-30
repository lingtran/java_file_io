
import org.junit.Test;

import static org.junit.Assert.*;

public class SalesTaxCalculatorTest {

    @Test
    public void testCalculate() {
        ShoppingBasket test 	= new ShoppingBasket();
        Item itemOne	 		= new Item( "1", "imported box of chocolates", "11.25" );
        Item itemTwo	 		= new Item( "1", "perfume", "10.79" );
        Double itemOneSalesTax	= 0.6;
        Double itemOneTotal		= 11.85;
        Double itemTwoSalesTax	= 1.1;
        Double itemTwoTotal		= 11.889999999999999;
        Double basketSalesTaxes = 1.7;
        Double basketTotal		= itemOneTotal + itemTwoTotal;

        test.getBasketOfItems().add(itemOne);
        test.getBasketOfItems().add(itemTwo);
        SalesTaxCalculator.calculate(test);

        assertEquals( itemOneSalesTax, itemOne.salesTax );
        assertEquals(  itemOneTotal, itemOne.total );
        assertEquals (itemTwoSalesTax, itemTwo.salesTax );
        assertEquals( itemTwoTotal, itemTwo.total );
        assertEquals( basketSalesTaxes, test.getSalesTaxes() );
        assertEquals( basketTotal, test.getTotal() );
    }

    @Test
    public void testDetermineItemBasicSalesTax() {
        Item testOne 		   = new Item( "1", "perfume", "10.79" );
        Double testOneSalesTax = 1.1;

        testOne.determineIfExempt();
        SalesTaxCalculator.determineItemBasicSalesTax(testOne);

        assertFalse( testOne.exemptionStatus );
        assertEquals( testOneSalesTax, testOne.salesTax );

        Item testTwo		   = new Item( "1", "chocolate", "10.00" );
        Double testTwoSalesTax = 0.00;

        testTwo.determineIfExempt();
        assertTrue(  testTwo.exemptionStatus );

        SalesTaxCalculator.determineItemBasicSalesTax(testTwo);
        assertEquals( testTwoSalesTax, testTwo.salesTax );
    }

    @Test
    public void testDetermineItemImportDuty() {
        Item testOne			    = new Item( "1", "box of books", "27.99" );
        Double testOneBasicSalesTax = 0.0;
        Double testOneImportDuty 	= 0.0;
        Double testOneSalesTax 		= testOneBasicSalesTax + testOneImportDuty;

        SalesTaxCalculator.determineItemBasicSalesTax(testOne);
        SalesTaxCalculator.determineItemImportDuty(testOne);

        assertTrue( testOne.exemptionStatus );
        assertFalse( testOne.importStatus );
        assertEquals( testOneBasicSalesTax, testOne.salesTax );
        assertEquals( testOneImportDuty, testOne.salesTax );
        assertEquals( testOneSalesTax, testOne.salesTax );

        Item testTwo				= new Item( "1", "imported bottle of perfume", "18.99" );
        Double testTwoSalesTax	    = 2.85;

        SalesTaxCalculator.determineItemBasicSalesTax(testTwo);
        SalesTaxCalculator.determineItemImportDuty(testTwo);

        assertFalse( testTwo.exemptionStatus );
        assertTrue( testTwo.importStatus );
        assertEquals( testTwoSalesTax, testTwo.salesTax );
    }

    @Test
    public void testRoundUpSalesTax() {
        Double taxOne		 = 7.61;
        Double roundedTaxOne = 7.65;
        Double taxTwo		 = 6.50;
        Double roundedTaxTwo = 6.50;

        Double testOne = SalesTaxCalculator.roundUpSalesTax(taxOne);
        Double testTwo = SalesTaxCalculator.roundUpSalesTax(taxTwo);

        assertEquals( roundedTaxOne, testOne );
        assertEquals( roundedTaxTwo, testTwo );

        Item importedChoco	 		  = new Item("1", "imported box of chocolates", "10.00");
        Item importedPerfume		  = new Item("1", "imported bottle of perfume", "47.50");
        Double roundedChocoSalesTax	  = 0.5;
        Double roundedPerfumeSalesTax = 7.15;

        SalesTaxCalculator.determineItemBasicSalesTax(importedChoco);
        SalesTaxCalculator.determineItemImportDuty(importedChoco);
        SalesTaxCalculator.determineItemBasicSalesTax(importedPerfume);
        SalesTaxCalculator.determineItemImportDuty(importedPerfume);

        assertEquals( roundedChocoSalesTax, importedChoco.salesTax );
        assertEquals( roundedPerfumeSalesTax, importedPerfume.salesTax );
    }
}
