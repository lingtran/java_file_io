
public class Item {
    private static final String[] BOOKS			   = { "book" };
    private static final String[] FOOD 		  	   = { "chocolate" };
    private static final String[] MEDICAL_PRODUCTS = { "pills" };

    Integer quantity;
    String name = null;
    Double price;
    Double salesTax;
    Double total;
    public Boolean exemptionStatus = false;
    public Boolean importStatus	   = false;

    public static void main(String[] args) {

    }

    public Item(String q, String n, String p){
        quantity 		= convertToInteger(q);
        name 	 		= n;
        price 	 		= convertToDouble(p);
        salesTax		= 0.0;
        total			= price;
        exemptionStatus = determineIfExempt();
        importStatus 	= determineIfImported();
    }

    public static Double convertToDouble(String p) throws NumberFormatException {
        return Double.parseDouble(p);
    }

    public static Integer convertToInteger(String q) {
        return Integer.parseInt(q);
    }

    public boolean determineIfExempt() {
        scanForKeywordMatch(BOOKS);
        scanForKeywordMatch(FOOD);
        scanForKeywordMatch(MEDICAL_PRODUCTS);
        return exemptionStatus;
    }

    public boolean determineIfImported() {
        if( name.toLowerCase().contains("imported") ) {
            importStatus = true;
        }
        return importStatus;
    }

    private void scanForKeywordMatch(String[] collection) {
        for(String element: collection) {
            if( name.toLowerCase().contains(element) ) {
                exemptionStatus = true;
                break;
            }
        }
    }

}
