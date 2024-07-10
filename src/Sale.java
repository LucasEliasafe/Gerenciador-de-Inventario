import java.time.LocalDate;

public class Sale {
    private Product product;
    private int quantitySold;
    private LocalDate date;

    public Sale(Product product, int quantitySold, LocalDate date) {
        this.product = product;
        this.quantitySold = quantitySold;
        this.date = date;
    }


}
