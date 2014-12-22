import java.util.ArrayList;

/**
 * Created by NotePad on 17.12.2014.
 */
public class Demand extends ArrayList<Good> {

    private String customerName;
    private String customerTelephone;
    private boolean isAvailable;
    DataAccessor dataAccessor;


    public Demand() {
        super();

        customerName = "";
        customerTelephone = "";
        isAvailable = false;

        dataAccessor = new DataAccessor();
    }

    public  void elementWasAddedToInventory(Good item){
        this.isAvailable = this.isAvailable();
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
}
