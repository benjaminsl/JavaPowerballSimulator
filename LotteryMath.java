import java.util.Arrays;
import java.util.Random;

public class LotteryMath
{
	/* two arrays: one for the user's number (quickpick)
	 *             one for the winning numbers
	 * both will be filled randomly 
	 */
	
	/* return string of array */
	public static String ShowNumbers(int[] numbers)
	{
		return Arrays.toString(numbers);
	}
	
	/* Pick numbers at random, for both the user's ticket
	 * and for the winning numbers */
	public static void FillArray(int[] array)
	{
		/* an array for used numbers to check to make sure
		 * numbers aren't repeated */
		int[] numbers_already_chosen = new int[70];
		int random_number;
		
		for (int i = 0; i < array.length; i++)
		{
			
			// If it's the first interation, no need to check for duplicates
			if (i == 0)
			{	
				random_number = GetRandomNumberBetween1and69();
				array[i] = random_number;
			}
			
			// If it's not the first iternation, check for duplicates
			else if (i > 0 && i < 5) // if it's not the last element (the powerball)
			{
				random_number = GetRandomNumberBetween1and69();
				
				// see if random_number is a duplicate already found in array
				// if it is, create a new random number until it is not a duplicate
				while (SearchArrayForInt(array, random_number) == true)
				{
					random_number = GetRandomNumberBetween1and69();
				}
				
				array[i] = random_number;
			} // end if
			
			else if (i == 5)
			{
				random_number = GetRandomNumberBetween1and26();
				
				// see if random_number is a duplicate already found in array
				// if it is, create a new random number until it is not a duplicate
				while (SearchArrayForInt(array, random_number) == true)
				{
					random_number = GetRandomNumberBetween1and26();
				}
				
				array[i] = random_number;
			}
			
		} // end for
		
	} // end FillArray
	
	
	
	/* Generate a random number between 1 and 69 */
	private static int GetRandomNumberBetween1and69()
	{
		Random rand = new Random();
		
		int randomNumberBetween1and69 = (rand.nextInt(69) + 1); // will be a number between 1 and 69
		return randomNumberBetween1and69;
	}
	
	/* Generate a random number between 1 and 26 */
	private static int GetRandomNumberBetween1and26()
	{
		Random rand = new Random();
		
		int randomNumberBetween1and26 = (rand.nextInt(26) + 1); // will be a number between 1 and 69
		return randomNumberBetween1and26;
	}
	
	/* Because matching numbers can be in any order, every of 
	 * the first array must be checked against any element of the second array. */
	/* this method will check how many elements in the array are equal */
	public static int CheckIfArraysAreEqual(int[] array1, int[] array2)
	{
		int number_of_equal_elements = 0;
		
		/* 1: Check every element in first array one by one. */
		for (int i = 0; i < array1.length; i++)
		{
			//System.out.println(array1[i] + " ");
			//System.out.println("------------- ");
			
			/* 2. Against every element in second array. */
			for (int j = 0; j < array2.length; j++)
			{
				//System.out.println(array2[j] + " ");
				/* If a match is found -- array1[i] == array[2] means match is found */
				if (array1[i] == array2[j]) number_of_equal_elements++;
			}
		}
		return number_of_equal_elements;
	} // end CheckIfArraysAreEqual
	
	/* search an array to see if there is an integer in the array. */
	public static boolean SearchArrayForInt(int[] array, int targetValue)
	{
		for (int i : array)
		{
			if (i == targetValue)
				return true;
		}
		
		return false;
	} // end SearchArrayForItn
	
} // End LotteryMath.java