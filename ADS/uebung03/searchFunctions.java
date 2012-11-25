package uebung03;
import static gdi.MakeItSimple.*;

public class  searchFunctions{
	
// Geänderte Variablen
// bereichAnfang = searchAreaStart
// bereichEnde = searchAreaEnd

	public static void main(String[] args) {
	
		int[] testArray = new int[1000];
		
		// Loop to fill an array.
		for(int i = 0; i < testArray.length; i++)
		{
			testArray[i] = i;
		}
		
		// Search for a random number.
		int testNumber = (int)Math.floor(Math.random() * testArray.length);
			println(searchLastIndex(testArray, testNumber));
			println(searchFirstIndex(testArray, testNumber));
			println(searchBinaryRecursive(testArray, testNumber, 0, testArray.length));
			println(searchBinary(testArray, testNumber, 0, testArray.length));
	}
	
	// Search for the last index in the array and return it's position.
	// The complete array will be checked and the last saved position will be returned.	
	public static int searchLastIndex(int[] targetArray, int searchNumber)
	{
		int resultIndex = -1;
		
		for(int i = 0; i < targetArray.length; i++)
		{
			if(targetArray[i] == searchNumber)
			{
				resultIndex = i;
			}
		}
		return resultIndex;
	}
	
	// Search for the first position of the number in the array.	
	// The method returns as soon as the first postition of the number were found.
	public static int searchFirstIndex(int[] targetArray, int searchNumber)
	{	
		for(int i = 0; i < targetArray.length; i++)
		{
			if(targetArray[i] == searchNumber)
			{
				return i;
			}
		}
		return -1;
	}
	
	// Recursive binary search.
	// As long as the checked number is smaller or bigger than the searched one the method returns to the beginning and starts again with 
	// different values.
	public static int searchBinaryRecursive(int[] targetArray, int searchInt, int searchAreaStart, int searchAreaEnd) {

		int i = ((searchAreaEnd - searchAreaStart) / 2) + searchAreaStart;

		if (searchAreaStart > searchAreaEnd) {
			return -1;
		}
		if (targetArray[i] == searchInt) {
			return i;
		}
		if (targetArray[i] < searchInt) {
			return searchBinaryRecursive(targetArray, searchInt, i + 1, searchAreaEnd);
		}
		if (targetArray[i] > searchInt) {
			return searchBinaryRecursive(targetArray, searchInt, searchAreaStart, i - 1);
		}
		return -1;
	}
	
	// Binary search.
	// The binary search without recursion is working as a loop, that changes the values if the checked number 
	// is bigger or smaller than the searched one.
	public static int searchBinary(int[] targetArray, int searchInt, int searchAreaStart, int searchAreaEnd) {

		while(searchAreaStart <= searchAreaEnd){
			
			int i = ((searchAreaEnd - searchAreaStart) / 2) + searchAreaStart;
			
			if (targetArray[i] == searchInt) {
				return i;
			}
			
			if (targetArray[i] < searchInt) {
				searchAreaStart = i + 1;
			}
			
			if (targetArray[i] > searchInt) {
				searchAreaEnd = i - 1;
			}
		}
		return -1;
	}
}