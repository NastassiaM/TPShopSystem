import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by NotePad on 17.12.2014.
 */
public class OrderList extends ArrayList<Order>{

    public OrderList() {
        super();
    }

    public void writeToFile(){
        try {
            FileWriter fw = new FileWriter("orderList.txt");
            for (Order order: this){
                fw.write(order.toString());
            }
            fw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing in file", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void initFromFile(){
        try {
            Scanner sc = new Scanner (new File("orderList.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                Order order = new Order();
                this.add(order.fromString(str));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.OK_OPTION);
        }
    }
}
