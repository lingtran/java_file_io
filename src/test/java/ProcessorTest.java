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
        Processor test                = new Processor();
        ShoppingBasket testBasket 	  = test.getShoppingBasket();
        ArrayList<Item> testItems 	  = testBasket.getBasketOfItems();
        ShoppingBasket shoppingBasket = new ShoppingBasket();

        assertThat( testBasket, instanceOf(shoppingBasket.getClass()) );
        assertThat( testItems, IsEmptyCollection.empty() );
    }

    @Test
    public void testAddItemToBasket() {
        Processor test = new Processor();
        ShoppingBasket testBasket = test.getShoppingBasket();
        Item itemOne   = new Item( "1", "imported box of chocolates", "10.00" );
        Item itemTwo   = new Item( "1", "strawberries", "5.00" );

        ArrayList<Item> testItems = new ArrayList<Item>();
        testItems.add(itemOne);
        testItems.add(itemTwo);

        assertEquals( 0, testBasket.getBasketOfItems().size() );

        test.addItemToBasket(itemOne);

        assertEquals( 1, testBasket.getBasketOfItems().size() );
        assertTrue( testBasket.getBasketOfItems().contains(itemOne) );
        assertFalse( testBasket.getBasketOfItems().contains(itemTwo) );

        test.addItemToBasket(itemTwo);

        assertEquals( 2, testBasket.getBasketOfItems().size());
        assertTrue( testBasket.getBasketOfItems().containsAll(testItems) );
        assertFalse( testBasket.getBasketOfItems().get(1).getName().equals(itemOne.getName()) );
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

        assertEquals( itemOneSalesTax, itemOne.getSalesTax());
        assertEquals( itemOneTotal, itemOne.getTotal());
        assertEquals( itemTwoSalesTax, itemTwo.getSalesTax());
        assertEquals( shoppingBasketSalesTaxes, test.getShoppingBasket().getSalesTaxes() );
        assertEquals( shoppingBasketTotal, test.getShoppingBasket().getTotal() );
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