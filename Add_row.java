package algoProject;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Add_row {
  public static void main(String[] argv) throws Exception {
    DefaultTableModel model = new DefaultTableModel();
    JTable table = new JTable(model);

    model.addColumn("Col1");
    model.addColumn("Col2");

    // Create the first row
    model.insertRow(0, new Object[] { "r1" });
    model.insertRow(1, new Object[] { "r1" });
    model.insertRow(2, new Object[] { "r1" });
    
    // Insert a row at position p
    int p = 3;
    model.insertRow(p, new Object[] { "r3" });
    
    JFrame f = new JFrame();
    f.setSize(300, 300);
    f.add(new JScrollPane(table));
    f.setVisible(true);
  }
}
