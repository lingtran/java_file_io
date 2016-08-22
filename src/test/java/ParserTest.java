
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParserTest {

    @Test
    public void testParseItem() {
        String line	 = "1 imported box of chocolates at 10.00";
        Item newItem = new Item("1", "imported box of chocolates", "10.00");

        assertThat( Parser.parseItem(line), instanceOf(newItem.getClass()) );
    }

}