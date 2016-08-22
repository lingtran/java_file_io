import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingBasketTest {

    @Test
    public void testShoppingBasketConstructor() {
        ShoppingBasket test = new ShoppingBasket();

        assertThat(test.basketOfItems, IsEmptyCollection.empty());
    }

}
