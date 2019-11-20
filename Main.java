/** File: Main.java **/
/** Project: PowerballSimulator **/
/** Author: Benjamin Leach, 2019 **/

/** Purpose: This program simulates a person
 ** 		 playing the lottery every day 
 **          until the person wins.
 **/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 
 
public class Main
{
	public static void main(String[] args)
	{
		/* ___________________________________ */
		/*                                     */
		/*           SWING STUFF               */
		/* ___________________________________ */
		
		 // Creating instance of JFrame
        //JFrame frame = new JFrame("My First Swing Example");
        // Setting the width and height of frame
		JFrame frame = new JFrame("Powerball Simulator");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Creating panel. This is same as a div tag in HTML
         * We can create several panels and add them to specific 
         * positions in a JFrame. Inside panels we can add text 
         * fields, buttons and other components.
         */
        JPanel panel = new JPanel();    
        // adding panel to frame
        frame.add(panel);
        /* calling user defined method for adding components
         * to the panel.
         */
            /* We will discuss about layouts in the later sections
         * of this tutorial. For now we are setting the layout 
         * to null
         */
        panel.setLayout(null);

		/*********** LABELS FOR WINDOW *****************/
        JLabel userLabel = new JLabel("User: ");
        userLabel.setBounds(10, 20, 150, 25);
        panel.add(userLabel);
		
		// user ticket numbers
		JLabel userNumbers = new JLabel("");
		userNumbers.setBounds(120, 20, 150, 25);
		panel.add(userNumbers);
		
        JLabel winningLabel = new JLabel("Winning Numbers: ");
        winningLabel.setBounds(10, 50, 150, 25);
        panel.add(winningLabel);
		
		// user ticket numbers
		JLabel winningNumbers = new JLabel("");
		winningNumbers.setBounds(120, 50, 150, 25);
		panel.add(winningNumbers);
		
		// display how many numbers match
		JLabel resultsMatchesLabel = new JLabel();
		resultsMatchesLabel.setBounds(10, 120, 150, 25);
		panel.add(resultsMatchesLabel);
		
		// display time played
		JLabel resultsTimeDaysLabel = new JLabel();
		resultsTimeDaysLabel.setBounds(10, 140, 400, 25);
		panel.add(resultsTimeDaysLabel);
		
		// display time (Year, Week, Day) played
		JLabel resultsTimeYWDLabel = new JLabel();
		resultsTimeYWDLabel.setBounds(10, 160, 400, 25);
		panel.add(resultsTimeYWDLabel);
		
		/******* ENDING LABELS FOR WINDOW ****************/

		// Creating login button
        JButton beginButton = new JButton("Begin");
        beginButton.setBounds(10, 80, 80, 25);
        panel.add(beginButton);
		
		//beginButton.addActionListener()
		//{
			//public void actionPerformed(ActionEvent event)
			//{
				//JOptionPane.showMessageDialog(this, textBox.getText());
			//}
		//});
		
        // Setting the frame visibility to true
        frame.setVisible(true);
		
		/* ___________________________________ */
		/*                                     */
		/*         ARRAY OPERATIONS            */
		/* ___________________________________ */
		
		/* two arrays: one for the user's number (quickpick)
		 * one for the winning numbers
		 * both will be filled randomly 
		 */
		
		int[] quickpick = new int[6];
		int[] winningnumbers = new int[6];
	
		int matches = 0;
		int days = 0; // how many attemps to find the correct number of matches in the arrays
		
		/* Strings to hold the toString versions of the arrays quickpick and winningnumbers
		*/
		String quickpickString = "";
		String winningnumbersString = "";

		while (matches != 3)
		{
			LotteryMath.FillArray(quickpick);
			LotteryMath.FillArray(winningnumbers);
			
			quickpickString = LotteryMath.ShowNumbers(quickpick);
			winningnumbersString = LotteryMath.ShowNumbers(winningnumbers);
			
			// return number of matches between quickpick and winningnumbers
			matches = LotteryMath.CheckIfArraysAreEqual(quickpick, winningnumbers);

			// display text of quickpick and winning numbers in window
			
			WindowMethods.SetLabelText(userNumbers, quickpickString);
			WindowMethods.SetLabelText(winningNumbers, winningnumbersString);
			// Display every quickpick and winning numbers array
			//System.out.println(LotteryMath.ShowNumbers(quickpick));
			//System.out.println(LotteryMath.ShowNumbers(winningnumbers));
			
			System.out.println();
			
			days++;
		}
		
		/******* RESULTS TEXT *****************/
		String resultsNumbersThatMatch = "";
		String resultsTimeDaysPlayed = "";
		String resultsTimeConvertedPlayed = "";
		
		resultsNumbersThatMatch = "Numbers that match: " + matches;
		resultsTimeDaysPlayed = "You played for " + days + " days";
		resultsTimeConvertedPlayed = TimeConversions.PrintFormatYearWeekDay(days);
		
		WindowMethods.SetLabelText(resultsMatchesLabel, resultsNumbersThatMatch);
		WindowMethods.SetLabelText(resultsTimeDaysLabel, resultsTimeDaysPlayed);
		WindowMethods.SetLabelText(resultsTimeYWDLabel, resultsTimeConvertedPlayed);
		
		//System.out.println("Numbers that match: " + matches);
		System.out.println("You played for " + days + " days.");
		//TimeConversions.PrintFormatYearWeekDay(days);
		/********** END RESULTS TEXT ******************/
		
	}
}
