import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javafx.scene.control.ComboBox;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

//public class BasicDraw {
//  public static void main(String[] args) {
//    JFrame frame = new JFrame();
//    frame.add(new MyComponent());
//    frame.setSize(300, 300);
//    frame.setVisible(true);
//  }
//}

class MyComponent extends JComponent {
    public JComboBox xvalor = new JComboBox();
    public JComboBox yvalor = new JComboBox();
    
       

      

  public void paint(Graphics g,String path) {
    Graphics2D g2d = (Graphics2D) g;
    AffineTransform tx = new AffineTransform();
    xvalor.addItem("0");
    xvalor.addItem("50");
    xvalor.addItem("100");
    xvalor.addItem("200");
    xvalor.addItem("300");
     yvalor.addItem("0");
    yvalor.addItem("50");
    yvalor.addItem("100");
    yvalor.addItem("200");
    yvalor.addItem("300");
    xvalor.setVisible(true);
    yvalor.setVisible(true);
    double x = 300;
    double y = 100;
    tx.translate(x, y);

    g2d.drawImage(new ImageIcon(path).getImage(), new ImageIcon(path).getIconWidth(),new ImageIcon(path).getIconHeight(), null);
    g2d.setTransform(tx);
    g2d.drawImage(new ImageIcon(path).getImage(), tx, this);
  }
//    public static void main(String[] args) {
//       
//         JFrame frame = new JFrame();
//    frame.add(new MyComponent());
//    frame.setSize(300, 300);
//    frame.setVisible(true);
//    }
}