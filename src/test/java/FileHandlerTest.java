import org.junit.Test;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;


public class FileHandlerTest {
    @Test
    public void testReadFile() throws FileNotFoundException, URISyntaxException {
        String filename  = "src/main/resources/input_one";
        FileHandler test = new FileHandler();
        String testResult = test.readFile(filename);
        String result 	 = "[1 book at 12.49, 1 music CD at 14.99, 1 chocolate bar at 0.85]";

        assertEquals( result, testResult );
    }
}

