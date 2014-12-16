import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

/**
 * Created by Nastassia on 16.12.2014.
 */
public class OrderForm extends JFrame {

    public OrderForm() {
        super();

        this.setSize(400, 300);
        this.setTitle("Order form");
        this.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        JComponent panel1 = makeTextPanel("Panel #1");
        tabbedPane.addTab ("Demands", panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = makeTextPanel("Panel #2");
        tabbedPane.addTab("Orders", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);


        //Add the tabbed pane to this panel.
        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

    }


    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

}
