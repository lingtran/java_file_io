import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;


public class FileHandlerTest {

    @Test
    public void testmain() throws IOException {
        String filename  	  = "src/main/resources/input_three";
        FileHandler test 	  = FileHandler.main(filename);
        Processor processor   = test.processor;
        Item itemAtIndexOfOne = processor.items.get(1);
        Integer quantity	  = 1;

        assertTrue( processor.items.size() == 4 );
        assertEquals( "bottle of perfume", itemAtIndexOfOne.name );
        assertEquals( quantity, itemAtIndexOfOne.quantity );
        assertTrue( 18.99 == itemAtIndexOfOne.price );
        assertFalse( processor.items.get(0) == processor.items.get(3));
    }

    @Test
    public void testFileHandlerConstructor() throws FileNotFoundException {
        String filename 		= "src/main/resources/input_one";
        FileHandler test 		= new FileHandler();
        Processor testProcessor = test.processor;
        Processor processor 	= new Processor();

        assertThat( testProcessor, instanceOf(processor.getClass()) );
    }

    @Test
    public void testCanReadFile() throws FileNotFoundException {
        String filename  = "src/main/resources/input_one";
        FileHandler test = new FileHandler();

        String testResult = test.readFile(filename);

        String result 	 = "Successfully read file";

        assertEquals( result, testResult );

    }
}

