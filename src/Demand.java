import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by NotePad on 17.12.2014.
 */
public class Demand extends ArrayList<Good> {

    protected String customerName;
    protected  String customerTelephone;
    protected boolean isAvailable;
    protected String id;
    DataAccessor dataAccessor;
    static int count = 0;

    public Demand() {
        super();

        customerName = "";
        customerTelephone = "";
        isAvailable = false;
        id = "";

       // dataAccessor = new DataAccessor();
    }

    public Demand(String name, String phone) {
        super();

        customerName = name;
        customerTelephone = phone;
        isAvailable = false;

        id = name + (++count);

        //dataAccessor = new DataAccessor();
    }

    public  void elementWasAddedToInventory(Good item){
        this.isAvailable = this.isAvailable();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    public boolean isAvailable() {
        boolean t = true;
        for (Good good: this) {
            if (!dataAccessor.inventoryListContains(good))
            {
                t = false;
            }
        }
        return t;
    }

    public void setAvailable(boolean isAvailible) {
        this.isAvailable = isAvailible;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String result = id + " " + customerName + " " + customerTelephone;
        StringBuffer stringBuffer = new StringBuffer(result);
        for (Good good:this) {
            stringBuffer.append("<");
            stringBuffer.append(good.getTitle());
            stringBuffer.append(":");
            stringBuffer.append(good.getPrice());
            stringBuffer.append(":");
            stringBuffer.append(good.getCount());
            stringBuffer.append(">");
        }
        stringBuffer.append('\n');
        return stringBuffer.toString();
    }

    public Demand fromString(String string){
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        id = stringTokenizer.nextToken();
        customerName = stringTokenizer.nextToken();
        customerTelephone = stringTokenizer.nextToken();

        while (stringTokenizer.hasMoreTokens()){
            String strTitle = stringTokenizer.nextToken("<:>");
            String strPrice = stringTokenizer.nextToken("<:>");
            String strCount = stringTokenizer.nextToken("<:>");
            this.add(new Good(strTitle,  Integer.valueOf(strCount), Double.valueOf(strPrice)));
        }

        return this;
    }
}
