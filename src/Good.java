/**
 * Created by NotePad on 17.12.2014.
 */
public class Good {

    private  String title;
    private  double price;
    private  int count;

    public Good() {
        this.title = "";
        this.price = 0.0;
        this.count = 0;
    }

    public Good(String title, double price) {
        this.title = title;
        this.price = price;
        this.count = 0;
    }

    public Good(String title, double price, int count) {
        this.title = title;
        this.price = price;
        this.count = count;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object obj) {
        Good anotherGood = (Good)obj;
        return ((title.equalsIgnoreCase(anotherGood.getTitle())) && (price == anotherGood.price));
    }

    @Override
    public String toString() {
        return title + " " + price + " " + count;
    }
}
