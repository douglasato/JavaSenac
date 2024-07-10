// Fig. 13.11: FontJPanel.java
// Display strings in different fonts and colors.
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class FontJPanel extends JPanel
{
   // display Strings in different fonts and colors
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); 

      // set font to Serif (Times), bold, 12pt and draw a string 
      g.setFont(new Font("Arial", Font.BOLD, 22));
      g.drawString("Java", 22, 30);

      // set font to Monospaced (Courier), italic, 24pt and draw a string 
      g.setFont(new Font("", Font.ITALIC, 24));
      g.drawString("", 20, 50);

      // set font to SansSerif (Helvetica), plain, 14pt and draw a string 
      g.setFont(new Font("", Font.PLAIN, 14));
      g.drawString("", 22, 70);

      // set font to Serif (Times), bold/italic, 18pt and draw a string
      g.fillRect(20, 40, 100, 50);
      g.setColor(Color.BLUE);
      g.setFont(new Font("", Font.ITALIC, 22));
      g.drawString(g.getFont().getName() + "Senac" , 22, 70);
   } 
} // end class FontJPanel

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
