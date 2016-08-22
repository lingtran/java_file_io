public class Parser {
    public static void main(String[] args) {

    }

    public static Item parseItem(String line) {
        String[] itemAndPrice = line.split(" at ");
        String[] quantityAndName = itemAndPrice[0].split(" ", 2);
        Item newItem = new Item(quantityAndName[0], quantityAndName[1], itemAndPrice[1]);

        return newItem;
    }

}