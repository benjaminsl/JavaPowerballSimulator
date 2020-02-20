/** File: Main.java **/
/** Project: PowerballSimulator **/
/** Author: Benjamin Leach, 2019 **/

/** Purpose: This program simulates a person
 ** 		 playing the lottery every day 
 **          until the person wins.
 **/
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

import javax.swing.JOptionPane;
 
public class Main
{
	public static void main(String[] args)
	{
	/* ___________________________________ */
	/*                                     */
	/*           SWING STUFF               */
	/* ___________________________________ */

	// get when to stop program from user using JOption Dialog Box
	String numbersThatHaveToMatchString = JOptionPane.showInputDialog("Welcome to the Powerball Simulator. Please enter how many numbers you want to match to end simulation.");	

	// convert the string from j option pane box to int so it can be used further down in program
	int numbersThatHaveToMatchInt = Integer.parseInt(numbersThatHaveToMatchString);

	while (numbersThatHaveToMatchInt < 1 || numbersThatHaveToMatchInt > 6)
	{
		numbersThatHaveToMatchString = JOptionPane.showInputDialog("Please enter a number between 1 and 6 (inclusivly).");	
		numbersThatHaveToMatchInt = Integer.parseInt(numbersThatHaveToMatchString);
	}

  // Creating instance of JFrame
  // Setting the width and height of frame
	JFrame frame = new JFrame("Powerball Simulator");
  frame.setSize(350, 250);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  frame.setLayout(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	/*********** LABELS FOR WINDOW *****************/
   JLabel userLabel = new JLabel("User: ");
   userLabel.setBounds(10, 20, 150, 25);
   frame.add(userLabel);
		
		// user ticket numbers
		JLabel userNumbers = new JLabel("");
		userNumbers.setBounds(120, 20, 150, 25);
		frame.add(userNumbers);
		
    JLabel winningLabel = new JLabel("Winning Numbers: ");
    winningLabel.setBounds(10, 50, 150, 25);
    frame.add(winningLabel);
		
		// user ticket numbers
		JLabel winningNumbers = new JLabel("");
		winningNumbers.setBounds(120, 50, 150, 25);
		frame.add(winningNumbers);
		
		// display how many numbers match
		JLabel resultsMatchesLabel = new JLabel();
		resultsMatchesLabel.setBounds(10, 120, 150, 25);
		frame.add(resultsMatchesLabel);
		
		// display time played
		JLabel resultsTimeDaysLabel = new JLabel();
		resultsTimeDaysLabel.setBounds(10, 140, 400, 25);
		frame.add(resultsTimeDaysLabel);
		
		// display time (Year, Week, Day) played
		JLabel resultsTimeYWDLabel = new JLabel();
		resultsTimeYWDLabel.setBounds(10, 160, 400, 25);
		frame.add(resultsTimeYWDLabel);
		
		/******* ENDING LABELS FOR WINDOW ****************/

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

			while (matches != numbersThatHaveToMatchInt)
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
			} // end while
				
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
			} // end action performed
	} // end main
