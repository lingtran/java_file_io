public class Item {
    private static final String[] BOOKS = {"book"};
    private static final String[] FOOD = {"chocolate"};
    private static final String[] MEDICAL_PRODUCTS = {"pills"};

    private boolean exemptStatus = false;
    private boolean importStatus = false;

    private Integer quantity;
    private String name = null;
    private Double price;
    private Double salesTax;
    private Double total;

    public Item(String q, String n, String p) {
        setQuantity(convertToInteger(q));
        setName(n);
        setPrice(convertToDouble(p));
        setSalesTax(0.0);
        setTotal(getPrice());
        setExemptStatus(determineIfExempt());
        setImportStatus(determineIfImported());
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
        return isExemptStatus();
    }

    public boolean determineIfImported() {
        if (getName().toLowerCase().contains("imported")) {
            setImportStatus(true);
        }
        return isImportStatus();
    }

    private void scanForKeywordMatch(String[] collection) {
        for (String element : collection) {
            if (getName().toLowerCase().contains(element)) {
                setExemptStatus(true);
                break;
            }
        }
    }


    public boolean isExemptStatus() {
        return exemptStatus;
    }

    public void setExemptStatus(boolean exemptStatus) {
        this.exemptStatus = exemptStatus;
    }

    public boolean isImportStatus() {
        return importStatus;
    }

    public void setImportStatus(boolean importStatus) {
        this.importStatus = importStatus;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
