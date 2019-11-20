/* TimeCoversions.java */

public class TimeConversions
{
	public static String PrintFormatYearWeekDay(int days)
	{
		/* Year, weeks and days conversion  */
        int years = (days / 365);
        int weeks = (days % 365) / 7;
        int days_reamining  = (days % 365) % 7;

        /* Print total years, weeks and remaining days in given days */
		
		if (days > 364)
		{
			return "That's " + years + " years, " + weeks + " weeks, " + "and " + days_reamining + " days.";
		}
		
		else if (days > 7 && days < 365)
		{
			return "That's " + weeks + " weeks, " + "and " + days_reamining + " days.";
		}
		
		else if (days < 7)
		{
			return "That's " + days_reamining + " days."; 
		} // end else if
		
		else
		{
			return "Error";
		}
	} // end PrintFormatYearWeekDay
} // TimeConversions