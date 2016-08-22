import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    @Test
    public void testMainWithInputOneData() throws IOException {
        String inputOne = "src/main/resources/input_one";
        String[] argsOne = {inputOne};

        Application.main(argsOne);
        File receiptOne = new File(Application.receipt);
        assertTrue( receiptOne.exists() );
    }

    @Test
    public void testMainWithInputTwoData() throws IOException {
        String inputTwo = "src/main/resources/input_two";
        String[] argsTwo = {inputTwo};

        Application.main(argsTwo);
        File receiptTwo = new File(Application.receipt);
        assertTrue( receiptTwo.exists() );
    }

    @Test
    public void testMainWithInputThreeData() throws IOException {
        String inputThree = "src/main/resources/input_three";
        String[] argsThree = {inputThree};

        Application.main(argsThree);
        File receiptThree = new File(Application.receipt);
        assertTrue (receiptThree.exists() );
    }
}
