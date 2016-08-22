
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testItemConstructorWithItemDefaults() {
        String inputQuantity = "1";
        String inputName 	 = "perfume";
        String inputPrice 	 = "10.00";
        Integer quantity	 = 1;
        Double price		 = 10.00;

        Item test = new Item( inputQuantity, inputName, inputPrice );

        assertEquals( quantity, test.quantity );
        assertEquals( "perfume", test.name );
        assertEquals( price, test.price );
        assertFalse( test.exemptionStatus );
        assertFalse( test.importStatus );
    }

    @Test
    public void testConvertToInteger() {
        String inputQuantity = "1";
        Integer quantity	  = 1;

        assertEquals( quantity, Item.convertToInteger(inputQuantity) );
        assertThat( Item.convertToInteger(inputQuantity), instanceOf(quantity.getClass()) );

    }

    @Test
    public void testConvertToDouble() {
        String inputPrice = "10.00";
        Double price	  = 10.00;

        assertEquals( price, Item.convertToDouble(inputPrice) );
        assertThat( Item.convertToDouble(inputPrice), instanceOf(price.getClass()) );
    }

    @Test
    public void testDetermineIfExempt() {
        Item test 		 = new Item( "1", "allergy pills", "10.00" );
        Item testTwo	 = new Item( "1", "CHOCOlate", "10.00" );
        Item testThree	 = new Item( "1", "bottle of perfume", "18.99");
        Item testFour 	 = new Item( "1", "imported box of books", "10.00" );

        test.determineIfExempt();
        testTwo.determineIfExempt();
        testThree.determineIfExempt();
        testFour.determineIfExempt();

        boolean itemOneQualifiedExemptionStatus 	= test.exemptionStatus;
        boolean itemTwoQualifiedExemptionStatus		= testTwo.exemptionStatus;
        boolean itemThreeUnqualifiedExemptionStatus = testThree.exemptionStatus;
        boolean itemFourQualifiedExemptionStatus 	= testFour.exemptionStatus;

        assertTrue( itemOneQualifiedExemptionStatus );
        assertTrue( itemTwoQualifiedExemptionStatus );
        assertFalse( itemThreeUnqualifiedExemptionStatus );
        assertTrue( itemFourQualifiedExemptionStatus );
    }

    @Test
    public void testDetermineIfImported() {
        Item test = new Item( "1", "imported box of books", "10.00" );

        test.determineIfExempt();
        test.determineIfImported();

        boolean itemQualifiedExemptionStatus = test.exemptionStatus;
        boolean itemQualifiedImportStatus	 = test.importStatus;

        assertTrue( itemQualifiedExemptionStatus );
        assertTrue( itemQualifiedImportStatus );
    }

}