package uebung03;
import static gdi.MakeItSimple.*;

public class  searchFunctions{

	public static void main(String[] args) {
	
		int[] testArray = new int[1000];
		for(int i = 0; i < testArray.length; i++)
		{
			testArray[i] = i;
		}

		int testNumber = (int)Math.floor(Math.random() * testArray.length);
			println(searchLastIndex(testArray, testNumber));
			println(searchFirstIndex(testArray, testNumber));
			println(searchBinaryRecursive(testArray, testNumber, 0, testArray.length));
			println(searchBinary(testArray, testNumber, 0, testArray.length));
	}
	
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
	
	public static int searchBinaryRecursive(int[] targetArray, int searchInt, int bereichAnfang, int bereichEnde) {

		int i = ((bereichEnde - bereichAnfang) / 2) + bereichAnfang;

		if (bereichAnfang > bereichEnde) {
			return -1;
		}
		if (targetArray[i] == searchInt) {
			return i;
		}
		if (targetArray[i] < searchInt) {
			return searchBinaryRecursive(targetArray, searchInt, i + 1, bereichEnde);
		}
		if (targetArray[i] > searchInt) {
			return searchBinaryRecursive(targetArray, searchInt, bereichAnfang, i - 1);
		}

		return -1;
	}
	
	public static int searchBinary(int[] targetArray, int searchInt, int bereichAnfang, int bereichEnde) {

		while(bereichAnfang <= bereichEnde){
			
			int i = ((bereichEnde - bereichAnfang) / 2) + bereichAnfang;
			
			if (targetArray[i] == searchInt) {
				return i;
			}
			
			if (targetArray[i] < searchInt) {
				bereichAnfang = i + 1;
			}
			
			if (targetArray[i] > searchInt) {
				bereichEnde = i - 1;
			}
		}
		return -1;
	}
}

