import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Viktoria
 * @version 1.0
 * @created 16-12-2014 23:28:20
 */
public class CatalogOfGoods extends ArrayList<Good> {

	CatalogOfGoods(){ //should be removed database-connect method
        super();

        try {
            Scanner sc = new Scanner (new File("catalog.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                StringTokenizer strtok = new StringTokenizer(str);
                int k = strtok.countTokens();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < (k - 1); i ++)
                {
                    stringBuffer.append(strtok.nextToken());
                    stringBuffer.append(' ');
                }
                String title = stringBuffer.toString();
                double price = Double.valueOf(strtok.nextToken());
                this.add(new Good(title, price));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.OK_OPTION);
        }
    }

	public void updateCatalog(InventoryList inventoryList){
        for (Good good: inventoryList)
        {
            int i = this.indexOf(good);
            this.get(i).setPrice(good.getPrice());
        }
    }

    public Good getGood(String name){
        for(Good good:this){
            if(good.getTitle().equalsIgnoreCase(name))
                return good;
        }
        return null;
    }
}