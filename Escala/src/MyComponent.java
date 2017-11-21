import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javafx.scene.control.ComboBox;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    
    ImageIcon ico=new ImageIcon("C:/Users/mario/Desktop/VIII Semestre/SEMINARIOS/Progresso do Tema/images/difusi.jpg");

    public MyComponent() {
        JButton bt=new JButton("Transladar");
        bt.addActionListener(null);
//        this.add(bt);
        
        
//         JFrame frame = new JFrame();
//        frame.add(new MyComponent());
//        frame.add(bt);
//        frame.setSize(1000, 500);
//        frame.setVisible(true);
    }

  

  public void paint(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    AffineTransform tx = new AffineTransform();
    double x = 300;
    double y = 100;
    tx.translate(x, y);
    
    g2d.drawImage(ico.getImage(), ico.getIconWidth(),ico.getIconHeight(), null);
    g2d.setTransform(tx);
    
    g2d.drawImage(ico.getImage(), tx, this);
  }
//    public static void main(String[] args) {
////       
//         JFrame frame = new JFrame();
//    frame.add(new MyComponent());
//        JButton bt=new JButton("Transladar");
//        bt.addActionListener(null);
//        frame.add(bt);
//    frame.setSize(1000, 500);
//    frame.setVisible(true);
//    }
}