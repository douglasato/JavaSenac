// Fig. 13.18: LinesRectsOvalsJPanel.java
// Drawing lines, rectangles and ovals.
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Font;

public class LinesRectsOvalsJPanel extends JPanel 
{
   // display various lines, rectangles and ovals
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 
      this.setBackground(Color.WHITE);

      g.setFont(new Font("Monospaced", Font.ITALIC, 12));
      g.drawString("Olá mundo!", 15, 74);
      g.setColor(Color.RED);
      g.drawLine(5, 30, 380, 30);

      g.setColor(Color.BLUE);
      g.drawRect(5, 40, 90, 55);
      g.drawString("Programação", 115, 135);
      g.fillRect(100, 40, 90, 55);
      g.drawString("Senac 2024", 15, 135);

      g.setColor(Color.BLACK);
      g.fillRoundRect(195, 40, 90, 55, 50, 50);
      g.drawString("Bem vindo! ", 115, 74);     
      g.drawRoundRect(290, 40, 90, 55, 20, 20);
      g.drawString("Senac", 225, 135);

      g.setColor(Color.GREEN);   
      g.draw3DRect(5, 100, 90, 55, true);
      g.drawString("Curso Java", 210, 74);

      g.fill3DRect(100, 100, 90, 55, false);
      g.setColor(Color.BLACK);
      g.drawString("Lorem Ipsum", 110, 135);  

      g.setColor(Color.MAGENTA);
      g.drawOval(195, 100, 90, 55);
      g.drawString("Programação", 300, 74);
      g.fillOval(290, 100, 150, 55);
      g.setColor(Color.WHITE);
      g.drawString("Senac turma 2024", 310, 135);

   } 
} // end class LinesRectsOvalsJPanel

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
