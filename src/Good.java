/**
 * Created by NotePad on 17.12.2014.
 */
public class Good {

    private  String title;
    private  double price;

    public Good() {
        this.title = "";
        this.price = 0.0;
    }

    public Good(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
