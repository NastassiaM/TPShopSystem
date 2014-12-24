import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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


    public void initFromFile(){
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

                this.add(new Good(name, count, price));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.OK_OPTION);
        }
    }


    public boolean writeToFile(){
        try {
            FileWriter fw = new FileWriter("inventory.txt");
            for (Good good:this){
                fw.write(good.toString() + '\n');
            }
            fw.close();
            return true;
        } catch (IOException e) {
            //JOptionPane.showMessageDialog (null, "Error writing in file", "Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }
}
