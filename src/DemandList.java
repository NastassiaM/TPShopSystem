import java.util.ArrayList;

/**
 * Created by NotePad on 17.12.2014.
 */
public class DemandList extends ArrayList<Demand> {

    public DemandList() {
        super();
    }

    public void itemWasAdded(Good item)
    {
        for (Demand demand: this)
        {
            demand.elementWasAddedToInventory(item);
        }
    }
}
