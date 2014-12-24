import java.util.ArrayList;
import java.util.StringTokenizer;

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

    @Override
    public String toString() {
        return totalPrice + ":" + super.toString();
        /*StringBuffer stringBuffer = new StringBuffer(result);
        for (Good good:this) {
            stringBuffer.append("<");
            stringBuffer.append(good.getTitle());
            stringBuffer.append(":");
            stringBuffer.append(good.getPrice());
            stringBuffer.append(":");
            stringBuffer.append(good.getCount());
            stringBuffer.append(">");
        }
        return stringBuffer.toString();*/
    }

    public Order fromString(String string){
        StringTokenizer stringTokenizer = new StringTokenizer(string, "<:>");
        Double price = Double.valueOf(stringTokenizer.nextToken());

        id = stringTokenizer.nextToken();
        customerName = stringTokenizer.nextToken();
        customerTelephone = stringTokenizer.nextToken();

        while (stringTokenizer.hasMoreTokens()){
            String strTitle = stringTokenizer.nextToken();
            String strPrice = stringTokenizer.nextToken();
            String strCount = stringTokenizer.nextToken();
            this.add(new Good(strTitle, Integer.valueOf(strCount), Double.valueOf(strPrice)));
        }

        return this;
    }
}
