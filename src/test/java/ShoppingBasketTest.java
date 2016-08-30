import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class ShoppingBasketTest {

    @Test
    public void testShoppingBasketConstructor() {
        ShoppingBasket test = new ShoppingBasket();
        Double expected     = 0.0;

        assertThat(test.getBasketOfItems(), IsEmptyCollection.empty());
        assertEquals( expected, test.getSalesTaxes() );
        assertEquals( expected, test.getTotal() );
    }

}
