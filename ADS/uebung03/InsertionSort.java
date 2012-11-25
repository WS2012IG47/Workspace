package uebung03;
import static gdi.MakeItSimple.*;

/*
 * Gruppe 4 - 7
 * Philip Dombrowski, Matrikelnummer: 1220235
 * Tobias Kunz, Matrikelnummer: 1232749
 * Timm Dobhan, Matrikelnummer: 1232995
 */

public class InsertionSort {

	// anzahlDerVergleiche = comparisonCounter
	// anzahlDerVertauschungen = changeCounter
	// ausgabeInsertionSortBinary = outputInsertionSort
	// ausgabeInsertionSort = outputInsertionSort
	// bereichAnfang = searchAreaStart
	// bereichEnde = searchAreaEnd
	
	public static void main(String[] args) {
		int[] array = new int[1024];
		int[] array2 = new int[2048];
		int[] array3 = new int[4096];
		
	
		// Loops to fill the arrays with random numbers.
		for (int i = 0; i < array.length; i++){
			array[i] = (int)Math.floor(Math.random() * array.length);
		}
		for (int i = 0; i < array.length; i++){
			array2[i] = (int)Math.floor(Math.random() * array.length);
		}
		for (int i = 0; i < array.length; i++){
			array3[i] = (int)Math.floor(Math.random() * array.length);
		}
		
		// Print the sorted arrays and the counted changes and comparisons.		
		println("Insertion Sort");
		println("Arraygröße | Anzahl der Vertauschungen | Anzahl der Vergleiche");
		println(insertionSort(array));
		println(insertionSort(array2));
		println(insertionSort(array3));
		println();
		println("Duch Binäre Suche erweiterter Insertion Sort");
		println("Arraygröße | Anzahl der Vertauschungen | Anzahl der Vergleiche");
		println(insertionSortBinary(array));
		println(insertionSortBinary(array2));
		println(insertionSortBinary(array3));
	}
	
	// Insertion Sort.
	// The actual integer will be moved one field to the left until the integer in front of the moved integer isn't bigger.
	public static String insertionSort(int[] array){
		int newValue, j, changeCounter, comparisonCounter;
		changeCounter = comparisonCounter = 0;
		
		for (int i = 1; i < array.length; i++){
			newValue = array[i];
			j = i;
			comparisonCounter++;
			while (j > 0 && array[j - 1] > newValue){
				array[j] = array[j - 1];
				j--;
				changeCounter++;
			}
			array[j] = newValue;
		}
		String outputInsertionSort = (array.length + " | " + changeCounter + " | " + comparisonCounter);
		
		return outputInsertionSort;
	}
	
	// Insertion Sort with Binary Search.
	// The target position for the actual integer will be find by Binary Search. 
	// The values on the right side of the target position will be moved one field to the right so the actual integer can be inserted.
	public static String insertionSortBinary(int[] array){
		int changeCounter = 0;
		int comparisonCounter = 0;
		
		for (int i = 1; i < array.length; i++){
			int oldValue = array[i];
			
			int targetPosition = searchBinary(array, oldValue, 0, i - 1);
			
				for (int j = i; j > targetPosition; j--){
					array[j] = array[j - 1];
					changeCounter++;
				}	
		}
		String outputInsertionSortBinary = (array.length + " | " + changeCounter + " | " + comparisonCounter);
		return outputInsertionSortBinary;
	}
	
	// Binary Search
	// The binary search is looking for the position where the searched integer has to be inserted.
	// It searches for the right position in the already sorted area of the array.
	public static int searchBinary(int[] targetArray, int searchInt, int searchAreaStart, int searchAreaEnd) {
		int i = 0;
		while(searchAreaStart <= searchAreaEnd){
				
			i = ((searchAreaEnd - searchAreaStart) / 2) + searchAreaStart;
			
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
		return searchAreaStart;
	}	
}