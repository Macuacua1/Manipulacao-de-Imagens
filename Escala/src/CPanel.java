/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import javax.swing.JLabel;

/**
 *
 * @author Skeleton
 */
class CPanel extends JLabel {
  Image displayImage;

  BufferedImage biSrc;

  BufferedImage biDest; // Destination image is mandetory.

  BufferedImage bi; // Only an additional reference.

  Graphics2D big;

  CPanel() {
    setBackground(Color.black);
    loadImage();
    setSize(displayImage.getWidth(this), displayImage.getWidth(this)); 
    createBufferedImages();
    bi = biSrc;
  }

  public void loadImage() {
    displayImage = Toolkit.getDefaultToolkit().getImage("C:/Users/mario/Desktop/VIII Semestre/SEMINARIOS/Progresso do Tema/images/Arquitectura-Modelo proposto LFC 2017 - Page 1.png");
    MediaTracker mt = new MediaTracker(this);
    mt.addImage(displayImage, 1);
    try {
      mt.waitForAll();
    } catch (Exception e) {
      System.out.println("Exception while loading.");
    }
    if (displayImage.getWidth(this) == -1) {
      System.out.println("No jpg file");
      System.exit(0);
    }
  }

  public void createBufferedImages() {
    biSrc = new BufferedImage(displayImage.getWidth(this), displayImage
        .getHeight(this), BufferedImage.TYPE_INT_RGB);

    big = biSrc.createGraphics();
    big.drawImage(displayImage, 0, 0, this);

    biDest = new BufferedImage(displayImage.getWidth(this), displayImage
        .getHeight(this), BufferedImage.TYPE_INT_RGB);
  }

  public void sharpen() {
    float data[] = { -1.0f, -1.0f, -1.0f, -1.0f, 9.0f, -1.0f, -1.0f, -1.0f,
        -1.0f };
    Kernel kernel = new Kernel(3, 3, data);
    ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,
        null);
    convolve.filter(biSrc, biDest);
    bi = biDest;
  }

  public void blur() {
    float data[] = { 0.0625f, 0.125f, 0.0625f, 0.125f, 0.25f, 0.125f,
        0.0625f, 0.125f, 0.0625f };
    Kernel kernel = new Kernel(3, 3, data);
    ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,
        null);
    convolve.filter(biSrc, biDest);
    bi = biDest;
  }

    public void edgeDetect() {
    float data[] = { 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f,
        -1.0f };

    Kernel kernel = new Kernel(3, 3, data);
    ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,
        null);
    convolve.filter(biSrc, biDest);

    bi = biDest;
  }

  public void reset() {
    big.setColor(Color.black);
    big.clearRect(0, 0, bi.getWidth(this), bi.getHeight(this));
    big.drawImage(displayImage, 0, 0, this);
    bi = biSrc;
  }

  public void update(Graphics g) {
    g.clearRect(0, 0, getWidth(), getHeight());
    paintComponent(g);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2D = (Graphics2D) g;

    g2D.drawImage(bi, 0, 0, this);
  }
}