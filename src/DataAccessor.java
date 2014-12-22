import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
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

    public DataAccessor()
    {
        users = new ArrayList<User>();
        initUsers();

        demandList = new DemandList();

        orderList = new OrderList();

        inventoryList = new InventoryList();
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

    public  boolean inventoryListContains(Good good)
    {
        return inventoryList.contains(good);
    }
}
