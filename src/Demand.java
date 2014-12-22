import java.util.ArrayList;

/**
 * Created by NotePad on 17.12.2014.
 */
public class Demand extends ArrayList<Good> {

    private String customerName;
    private String customerTelephone;
    private boolean isAvailible;


    public Demand() {
        super();

        customerName = "";
        customerTelephone = "";
        isAvailible = false;
    }
}
