/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Skeleton
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ConvolveApp extends JFrame {
  CPanel displayPanel;

  JButton sharpenButton, blurringButton, edButton, resetButton;

  public ConvolveApp() {
    super();
    Container container = getContentPane();

    displayPanel = new CPanel();
    container.add(displayPanel);
     addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            { e.getWindow().dispose();
               new Scale().setVisible(true);
               
            }
        });

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(2, 2));
    panel
        .setBorder(new TitledBorder(
            "Click a Button to Perform the Associated Operation and Reset..."));

    sharpenButton = new JButton("Sharpen");
    sharpenButton.addActionListener(new ButtonListener());
    blurringButton = new JButton("Blur");
    blurringButton.addActionListener(new ButtonListener());
    edButton = new JButton("Edge Detect");
    edButton.addActionListener(new ButtonListener());
    resetButton = new JButton("Reset");
    resetButton.addActionListener(new ButtonListener());

    panel.add(sharpenButton);
    panel.add(blurringButton);
    panel.add(edButton);
    panel.add(resetButton);

    container.add(BorderLayout.SOUTH, panel);

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    setSize(displayPanel.getWidth(), displayPanel.getHeight() + 10);
    setVisible(true); 
    
  }
  public static void main(String arg[]) {
    new ConvolveApp();
  }
  

  class ButtonListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      JButton button = (JButton) e.getSource();

      if (button.equals(sharpenButton)) {
        displayPanel.sharpen();
        displayPanel.repaint();
      } else if (button.equals(blurringButton)) {
        displayPanel.blur();
        displayPanel.repaint();
      } else if (button.equals(edButton)) {
        displayPanel.edgeDetect();
        displayPanel.repaint();
      } else if (button.equals(resetButton)) {
        displayPanel.reset();
        displayPanel.repaint();
      }
    }
  }
}
