import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Nastassia on 14.12.2014.
 */
public class DataAccessor
{
    static ArrayList<User> users;
    static DemandList demandList;
    static OrderList orderList;
    static InventoryList inventoryList;
    static CatalogOfGoods catalogOfGoods;

    public DataAccessor()
    {
        users = new ArrayList<User>();
        initUsers();

        demandList = new DemandList();
        demandList.initFromFile();

        orderList = new OrderList();
        orderList.initFromFile();

        inventoryList = new InventoryList();
        inventoryList.initFromFile();
        //initInventoryList();

        catalogOfGoods = new CatalogOfGoods();
    }

    public  void initUsers(){
        try {
            Scanner sc = new Scanner (new File("users.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                StringTokenizer strtok = new StringTokenizer(str);
                int k = strtok.countTokens();
                String userName = strtok.nextToken();
                String password = strtok.nextToken();
                String position = strtok.nextToken();

                users.add(new User(userName, password, position));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.OK_OPTION);
        }
    }

/*    public void initInventoryList(){
        try {
            Scanner sc = new Scanner (new File("inventory.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                StringTokenizer strtok = new StringTokenizer(str);
                int k = strtok.countTokens();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i = 0; i < (k - 2); i ++)
                {
                    stringBuffer.append(strtok.nextToken());
                    stringBuffer.append(' ');
                }
                String name = stringBuffer.toString();
                Double price = Double.valueOf(strtok.nextToken());
                Integer count = Integer.valueOf(strtok.nextToken());

                inventoryList.add(new Good(name, count, price));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.OK_OPTION);
        }
    }*/

    public boolean checkUser(User user){
        if (users.contains(user))
        {
            user.setPosition(users.get(users.indexOf(user)).getPosition());
            return  true;
        }
        else
        {
            return  false;
        }
    }

    public void addItemToInventory(Good item)
    {
        if (inventoryList.contains(item))
        {
            Good good = inventoryList.get(inventoryList.indexOf(item));
            good.setCount(good.getCount() + 1);
        }
        else
        {
            inventoryList.add(item);
        }

        demandList.itemWasAdded(item);
    }

    public void deleteItemFromInventory(Good item)
    {
        if (inventoryList.contains(item))
        {
            Good good = inventoryList.get(inventoryList.indexOf(item));
            good.setCount(good.getCount() - 1);
            if (good.getCount() == 0)
            {
                inventoryList.remove(good);
            }
        }
    }

    public  boolean inventoryListContains(Good good) {
        return inventoryList.contains(good);
    }

    public static boolean saveInventoryList(InventoryList invList){
        inventoryList = invList;
        boolean result = inventoryList.writeToFile();
        /*try {
            FileWriter fw = new FileWriter("inventory.txt");
            for (Good good:inventoryList){
                fw.write(good.toString() + '\n');
            }
            fw.close();
        } catch (IOException e) {
            //JOptionPane.showMessageDialog (null, "Error writing in file", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
*/
        catalogOfGoods.updateCatalog(invList);
        //return true;
        return result;
    }
}
