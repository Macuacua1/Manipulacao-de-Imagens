
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mario
 */
public class Scale extends javax.swing.JFrame {
JFileChooser choose= new JFileChooser();
BufferedImage img;
 double rotate_angle;
    /**
     * Creates new form Scale
     */
    public Scale() {
        initComponents();
        img=null;
        JComboBox escala= new JComboBox();
        
//        escala.addItemListener(new ItemListener() {
//
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        escala = new javax.swing.JComboBox();
        Jtfcaminho = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        imageLoager1 = new imageLoager();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Escala");

        escala.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        escala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "200", "300", "400", "500" }));
        escala.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                escalaItemStateChanged(evt);
            }
        });
        escala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escalaActionPerformed(evt);
            }
        });

        Jtfcaminho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtfcaminhoActionPerformed(evt);
            }
        });

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imageLoager1Layout = new javax.swing.GroupLayout(imageLoager1);
        imageLoager1.setLayout(imageLoager1Layout);
        imageLoager1Layout.setHorizontalGroup(
            imageLoager1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        imageLoager1Layout.setVerticalGroup(
            imageLoager1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
        );

        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jButton2.setText("Translate");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(imageLoager1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(Jtfcaminho, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(escala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(escala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageLoager1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Jtfcaminho)
                    .addComponent(jButton2))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void escalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escalaActionPerformed
        
    }//GEN-LAST:event_escalaActionPerformed

    private void escalaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_escalaItemStateChanged
//       jLabel1.setVisible(true);
        String valor =escala.getSelectedItem().toString();
//           System.out.println(choose.getSelectedFile().getName());
                ImageIcon icon= new ImageIcon(getClass().getResource(choose.getSelectedFile().getName()));
        Image img= icon.getImage().getScaledInstance(Integer.parseInt(valor),Integer.parseInt(valor),Image.SCALE_SMOOTH);
        jLabel1.setIcon(new ImageIcon(img)); 
    }//GEN-LAST:event_escalaItemStateChanged

    private void JtfcaminhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtfcaminhoActionPerformed
        
    }//GEN-LAST:event_JtfcaminhoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        JFileChooser filechooser= new JFileChooser();
    choose.setDialogTitle("Choose Your File");
    choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
    //below codes for select  the file 
    int returnval=choose.showOpenDialog(this);
    if(returnval==JFileChooser.APPROVE_OPTION)
    {
        File file = choose.getSelectedFile();
        String filename=file.getAbsolutePath();
       Jtfcaminho.setText(filename);
        
        try
        {   //display the image in jlabel
            img=ImageIO.read(file);
            ImageIO.write(img, "jpg", new File("C:\\Users\\mario\\OneDrive\\Documents\\NetBeansProjects\\ImageRescaling\\src\\"+file.getName()));
//             System.out.println("Writing complete.");
            jLabel1.setIcon(new ImageIcon(img));
            
        }
        catch(IOException e)
        {

        }
//        this.pack();
    }
//        choose.setCurrentDirectory(new File(System.getProperty("user.home")));
//       FileNameExtensionFilter filter=new FileNameExtensionFilter("*.images","jpg","gif","png");
//      choose.addChoosableFileFilter(filter);
//      choose.showOpenDialog(null);
//       int result=choose.showOpenDialog(null);
//       if(result==JFileChooser.APPROVE_OPTION){
//         File f= choose.getSelectedFile();
//        String filename=f.getAbsolutePath();
//       Jtfcaminho.setText(filename);
////       ImageIcon icon= new ImageIcon(getClass().getResource(filename));
////       jLabel1.setIcon(new ImageIcon(icon.getImage()));
//       }
//       else if(result==JFileChooser.CANCEL_OPTION){
//       System.out.println("No File Selected");
//       }
    
//        return filename;
//        jLabel1.setIcon((Icon) f.getAbsoluteFile());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        
        RotateImage(jSlider1.getValue());
        setTitle(String.valueOf(jSlider1.getValue()*3.6));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Graphics g = null;
        paint(g);
    }//GEN-LAST:event_jButton2ActionPerformed
  public void pintar(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    AffineTransform tx = new AffineTransform();
    double x = 300;
    double y = 100;
    tx.translate(x, y);

    g2d.drawImage(new ImageIcon(choose.getSelectedFile().getName()).getImage(), new ImageIcon(choose.getSelectedFile().getName()).getIconWidth(),new ImageIcon(choose.getSelectedFile().getName()).getIconHeight(), null);
    g2d.setTransform(tx);
    g2d.drawImage(new ImageIcon(choose.getSelectedFile().getName()).getImage(), tx, this);
  }
      public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
    if(img!=null){
        Graphics2D g2D=(Graphics2D)g;
        g2D.translate((this.getSize().width/2), (this.getSize().height/2));
        g2D.rotate(Math.toRadians(rotate_angle));
        g2D.drawImage(img, -img.getWidth()/2, -img.getHeight()/2, null);
    }
    }
      public void RotateImage(int angle){
//      jLabel1.setVisible(false);
          rotate_angle=angle*3.6;
     repaint();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jtfcaminho;
    private javax.swing.JComboBox escala;
    private imageLoager imageLoager1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
}
