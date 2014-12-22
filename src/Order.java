import java.util.ArrayList;

/**
 * Created by NotePad on 17.12.2014.
 */
public class Order extends Demand{

    private double totalPrice;

    public Order() {
        super();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
