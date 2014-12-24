import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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

    public void writeToFile(){
        try {
            FileWriter fw = new FileWriter("demandList.txt");
            for (Demand demand: this){
                fw.write(demand.toString());
            }
            fw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error writing in file", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void initFromFile(){
        try {
            Scanner sc = new Scanner (new File("demandList.txt"));
            while(sc.hasNextLine()){
                String str = sc.nextLine();
                Demand demand = new Demand();
                this.add(demand.fromString(str));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.OK_OPTION);
        }
    }
}
