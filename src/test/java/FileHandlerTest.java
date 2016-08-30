import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;


public class FileHandlerTest {

    @Test
    public void testmain() throws IOException {
        String filename  	  = "src/test/resources/input_three.txt";
        FileHandler test 	  = FileHandler.main(filename);
        Processor processor   = test.processor;
        Item itemAtIndexOfOne = processor.getShoppingBasket().getBasketOfItems().get(1);
        Integer quantity	  = 1;

        assertTrue( processor.getShoppingBasket().getBasketOfItems().size() == 4 );
        assertEquals( "bottle of perfume", itemAtIndexOfOne.getName());
        assertEquals( quantity, itemAtIndexOfOne.getQuantity());
        assertTrue( 18.99 == itemAtIndexOfOne.getPrice());
        assertFalse( processor.getShoppingBasket().getBasketOfItems().get(0) == processor.getShoppingBasket().getBasketOfItems().get(3) );
    }

    @Test
    public void testFileHandlerConstructor() throws FileNotFoundException {
        String filename 		= "src/test/resources/input_one.txt";
        FileHandler test 		= new FileHandler();
        Processor testProcessor = test.processor;
        Processor processor 	= new Processor();

        assertThat( testProcessor, instanceOf(processor.getClass()) );
    }

    @Test
    public void testCanReadFile() throws FileNotFoundException {
        String filename   = "src/test/resources/input_one.txt";
        FileHandler test  = new FileHandler();
        String testResult = test.readFile(filename);
        String result     = "Successfully read file";

        assertEquals( result, testResult );

    }
}

