import java.util.ArrayList;

/**
 * Created by Viktoria on 17.12.2014.
 */
public class InventoryList extends ArrayList<Good>{
    InventoryList(){
        super();
    }
    public Good getGood(String name){
        for(Good good:this){
            if(good.getTitle().equalsIgnoreCase(name))
                return good;
        }
        return null;
    }
}
