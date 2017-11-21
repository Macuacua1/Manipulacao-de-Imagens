import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class TransformTranslation extends JComponent {
  Shape axes, shape;

  int length = 54, arrowLength = 4, tickSize = 4;

  public TransformTranslation() {
    axes = createAxes();
    shape = createShape();
  }

  protected Shape createAxes() {
    GeneralPath path = new GeneralPath();

    // Axes.
    path.moveTo(-length, 0);
    path.lineTo(length, 0);
    path.moveTo(0, -length);
    path.lineTo(0, length);
    // Arrows.
    path.moveTo(length - arrowLength, -arrowLength);
    path.lineTo(length, 0);
    path.lineTo(length - arrowLength, arrowLength);
    path.moveTo(-arrowLength, length - arrowLength);
    path.lineTo(0, length);
    path.lineTo(arrowLength, length - arrowLength);
    // Half-centimeter tick marks
    float cm = 72 / 2.54f;
    float lengthCentimeter = length / cm;
    for (float i = 0.5f; i < lengthCentimeter; i += 1.0f) {
      float tick = i * cm;
      path.moveTo(tick, -tickSize / 2);
      path.lineTo(tick, tickSize / 2);
      path.moveTo(-tick, -tickSize / 2);
      path.lineTo(-tick, tickSize / 2);
      path.moveTo(-tickSize / 2, tick);
      path.lineTo(tickSize / 2, tick);
      path.moveTo(-tickSize / 2, -tick);
      path.lineTo(tickSize / 2, -tick);
    }
    // Full-centimeter tick marks
    for (float i = 1.0f; i < lengthCentimeter; i += 1.0f) {
      float tick = i * cm;
      path.moveTo(tick, -tickSize);
      path.lineTo(tick, tickSize);
      path.moveTo(-tick, -tickSize);
      path.lineTo(-tick, tickSize);
      path.moveTo(-tickSize, tick);
      path.lineTo(tickSize, tick);
      path.moveTo(-tickSize, -tick);
      path.lineTo(tickSize, -tick);
    }
    return path;
  }

  protected Shape createShape() {
    float cm = 72 / 2.54f;
    return new Rectangle2D.Float(cm, cm, 2 * cm, cm);
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    // Use antialiasing.
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);

    // Move the origin to 75, 75.
    AffineTransform at = AffineTransform.getTranslateInstance(75, 75);
    g2.transform(at);

    // Draw the shapes in their original locations.
    g2.setPaint(Color.black);
    g2.draw(axes);
    g2.draw(shape);

    // Transform the Graphics2D.
      g2.transform(AffineTransform.getTranslateInstance(150, 0));

    // Draw the "new" shapes in dashed.
    Stroke stroke = new BasicStroke(1, BasicStroke.CAP_BUTT,
        BasicStroke.JOIN_BEVEL, 0, new float[] { 3, 1 }, 0);
    g2.setStroke(stroke);
    g2.draw(axes);
    g2.draw(shape);
  }

  public static void main(String[] a) {
    JFrame f = new JFrame();
    f.getContentPane().add(new TransformTranslation());
    f.setSize(450, 350);
    f.show();
  }
}
