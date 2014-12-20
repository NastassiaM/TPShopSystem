import java.util.ArrayList;

/**
 * @author Viktoria
 * @version 1.0
 * @created 16-12-2014 23:28:20
 */
public class CatalogOfGoods extends ArrayList<String> {

	CatalogOfGoods(){ //should be removed database-connect method
        super();

        String[] strArr = {"PocketBook 614", "PocketBook 622", "PocketBook 624", "Kindle", "Nook", "Brown Sweater"};
        for(int i = 0; i < strArr.length; i++){
            add(strArr[i]);
        }
    }

	public void finalize() throws Throwable {}

}