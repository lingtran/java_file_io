import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;


public class ProcessorTest {

    @Test
    public void testProcessorConstructor() {
        Processor test = new Processor();
        ShoppingBasket testBasket 	  = test.shoppingBasket;
        ArrayList<Item> testItems 	  = test.items;
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        assertThat( testBasket, instanceOf(shoppingBasket.getClass()) );
        assertThat( testItems, IsEmptyCollection.empty() );
    }

    @Test
    public void testAddItemToBasket() {
        Processor test = new Processor();
        Item itemOne   = new Item( "1", "imported box of chocolates", "10.00" );
        Item itemTwo   = new Item( "1", "strawberries", "5.00" );

        ArrayList<Item> testItems = new ArrayList<Item>();
        testItems.add(itemOne);
        testItems.add(itemTwo);

        assertEquals( 0, test.items.size() );

        test.addItemToBasket(itemOne);

        assertEquals( 1, test.items.size() );
        assertTrue( test.items.contains(itemOne) );
        assertFalse( test.items.contains(itemTwo) );

        test.addItemToBasket(itemTwo);

        assertEquals( 2, test.items.size());
        assertTrue( test.items.containsAll(testItems) );
        assertFalse(test.items.get(1).name.equals(itemOne.name));
        assertTrue( test.shoppingBasket.basketOfItems == test.items );
    }

    @Test
    public void testCallSalesTaxCalculator() {
        Processor test					 = new Processor();
        Item itemOne 				     = new Item( "1", "imported box of chocolates", "10.00" );
        Item itemTwo   					 = new Item( "1", "music CD", "14.99" );
        Double itemOneSalesTax		     = 0.5;
        Double itemOneTotal				 = 10.50;
        Double itemTwoSalesTax			 = 1.5;
        Double shoppingBasketSalesTaxes  = itemOneSalesTax + itemTwoSalesTax;
        Double shoppingBasketTotal		 = 26.990000000000002;

        test.addItemToBasket(itemOne);
        test.addItemToBasket(itemTwo);
        test.callSalesTaxCalculator();

        assertEquals( itemOneSalesTax, itemOne.salesTax );
        assertEquals( itemOneTotal, itemOne.total );
        assertEquals( itemTwoSalesTax, itemTwo.salesTax );
        assertEquals( shoppingBasketSalesTaxes, test.shoppingBasket.salesTaxes );
        assertEquals( shoppingBasketTotal, test.shoppingBasket.total );
    }

    @Test
    public void testGetReceipt() throws IOException {
        Processor test	  	  = new Processor();
        Item importedChoco	  = new Item("1", "imported box of chocolates", "10.00");
        Item importedPerfume  = new Item("1", "imported bottle of perfume", "47.50");

        test.addItemToBasket(importedChoco);
        test.addItemToBasket(importedPerfume);
        test.callSalesTaxCalculator();

        String filePath = test.getReceipt();
        File newReceipt = new File(filePath);

        assertTrue( newReceipt.exists() );
    }
}