package uebung04;
import static gdi.MakeItSimple.*;

/*
 * Gruppe 4 - 7
 * Philip Dombrowski, Matrikelnummer: 1220235
 * Tobias Kunz, Matrikelnummer: 1232749
 * Timm Dobhan, Matrikelnummer: 1232995
 */

public class Shellsort {

// Method to create three arrays with different sizes, 
// fill them with random numbers and print the counted changes and comparisons.
	public static void main(String[] args) {
		int[] array = new int[1024];
		int[] array2 = new int[2048];
		int[] array3 = new int[4096];
		
		// Loops to fill the arrays with random numbers.
		for (int i = 0; i < array.length; i++){
			array[i] = (int)Math.floor(Math.random() * array.length);
		}
		for (int i = 0; i < array.length; i++){
			array2[i] = (int)Math.floor(Math.random() * array2.length);
		}
		for (int i = 0; i < array.length; i++){
			array3[i] = (int)Math.floor(Math.random() * array3.length);
		}
	
		// Print the counted changes and comparisons.		
		println("Shell -Sort");
		println();
		println(shellsort(array));
		println();
		println(shellsort(array2));
		println();
		println(shellsort(array3));
	}
	
// Shellsort  
	public static String shellsort(int[] array) {
		int[] arrayCount = { 9, 7, 4, 1 };
		int comparisonCounter = 0;
		int changeCounter = 0;

		for (int ac = 0; ac < arrayCount.length; ac++) {

			for (int i = 0; i + arrayCount[ac] < array.length; i++) {
				int value1 = array[i];
				int value2 = array[i + arrayCount[ac]];

				// If the actual number is smaller than the number h-fields
				// before, the numbers will be changed.
				comparisonCounter++;
				if (value2 < array[i] && i >= arrayCount[ac]
						&& arrayCount[ac] != 1) {
					int value3 = 0;
					int c = i - arrayCount[ac];
					boolean moreChangesPossible = false;

					// When the number on position "i" is bigger than the
					// comparised one, it will be checked, if the number on position "i-h" is
					// also bigger.
					while (c >= 0 && value2 < array[c]) {
						comparisonCounter++;
						moreChangesPossible = true;
						value3 = array[c];
						c -= arrayCount[ac];
					}
					if (moreChangesPossible) {
						changeCounter++;
						array[c + arrayCount[ac]] = value2;
						array[i + arrayCount[ac]] = value3;
					}
					if (!moreChangesPossible) {
						changeCounter++;
						array[i] = value2;
						array[i + arrayCount[ac]] = value1;
					}
				}

				// The last run with h=1 is special, because the numbers between
				// position "i" and value2 have to move on field to the right.
				if (arrayCount[ac] == 1) {

					while (i > 0 && value2 < array[i]) {
						comparisonCounter++;
						changeCounter++;
						array[i + arrayCount[ac]] = array[i];
						array[i] = value2;
						i--;
					}
				}

				// When there can't be more than one change and the "value2" is
				// smaller than the number on position "i", the numbers will be changed.
				if (value2 < array[i] && i < arrayCount[ac]) {
					changeCounter++;
					array[i] = value2;
					array[i + arrayCount[ac]] = value1;
				}

// Print Array after every loop.
//				println();
//				for (int p = 0; p < array.length; p++) {
//					print(array[p] + " ");
//				}
//				println();
			}

		}
		String counter = ("Arraygröße: " + array.length + "\nAnzahl der Vergleiche: " + comparisonCounter + "\nAnzahl der Vertauschungen: " + changeCounter);
		return counter;
	}
}
