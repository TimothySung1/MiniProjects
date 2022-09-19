//display
   	//Name______________________________ Date_____________
   import java.awt.*;
   import java.awt.event.*;
   import javax.swing.*;
   public class Display12 extends JPanel
   {
      private JButton[] button;
      public Display12(ActionListener lis)
      {
         setLayout(new GridLayout(5, 5, 5, 5));
      
         button = new JButton[25];
         for(int x = 0; x < 25; x++)
         {
            button[x] = new JButton("" + (x + 1));
            button[x].addActionListener(lis);
            button[x].setHorizontalAlignment(SwingConstants.CENTER);
            button[x].setFont(new Font("Serif", Font.BOLD, 20));
            button[x].setBackground(Color.yellow);
            add(button[x]);
         }
      }

	public void reset()
      {
		  // Make all buttons have correct numbers on them.
		  // Make them enabled with yellow background
		  // And black foreground.
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
    	  
      }

	public void displayWinner(int target)
      {
		  // Make winning button green background.
		  // Disable all buttons.
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
      }
      public void displayLoser(int target)
      {
			// Make correct button black background
			// and grey foreground.
			// Disable all buttons.
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
      }
      public void displayTooHigh(int guess)
      {
  		  // Make all buttons that don't make sense
		  // disabled and colored red with no text.
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
    	  }
      }
      public void displayTooLow(int guess)
      {
		  // Make all buttons that don't make sense
		  // disabled and colored red with no text.
         	/************************/
         	/*                      */
         	/* Your code goes here. */
         	/*                      */
         	/************************/
      }
   }

