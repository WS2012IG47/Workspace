package uebung03;
import static gdi.MakeItSimple.*;

public class InsertionSort {

	public static void main(String[] args) {
		int[] array = new int[10];
	
		// Befüllen des Arrays mit zufälligen Zahlenwerten.
		for (int i = 0; i < array.length; i++){
			array[i] = (int)Math.floor(Math.random() * array.length);
		}
		// Ausgabe des unsortierten, generierten Arrays.
		for (int i = 0; i < array.length; i++){
			print(array[i] + "|");
		}
		println();
		println();
			
		insertionSort(array);
		insertionSortBinary(array);
	}
	
	public static void ausgabeInsertionSort(int[] insertionSortArray, int anzahlDerVertauschungen, int anzahlDerVergleiche){
		for (int i = 0; i < insertionSortArray.length; i++){
			print(insertionSortArray[i] + "|");
		}
		println();
		println("Anzahl der Vergleiche: " + anzahlDerVergleiche);
		println("Anzahl der Vertauschungen: " + anzahlDerVertauschungen);
		println();
	}
	
	public static void ausgabeInsertionSortBinary(int[] insertionSortBinaryArray, int anzahlDerVertauschungen, int anzahlDerVergleiche){
		for (int i = 0; i < insertionSortBinaryArray.length; i++){
			print(insertionSortBinaryArray[i] + "|");
		}
		println();
		println("Anzahl der Vergleiche: " + anzahlDerVergleiche);
		println("Anzahl der Vertauschungen: " + anzahlDerVertauschungen);
	}
	
	
// Einfacher Insertion Sort.
	public static void insertionSort(int[] array){
		int newValue, j, anzahlDerVertauschungen, anzahlDerVergleiche;
		anzahlDerVertauschungen = anzahlDerVergleiche = 0;
		
		for (int i = 0; i < array.length; i++){
			newValue = array[i];
			j = i;
			anzahlDerVergleiche++;
			while (j > 0 && array[j - 1] > newValue){
				array[j] = array[j - 1];
				j--;
				anzahlDerVertauschungen++;
			}
			array[j] = newValue;
		}
		
		ausgabeInsertionSort(array, anzahlDerVertauschungen, anzahlDerVergleiche);
		return;
	}
	
// Insertion Sort mit Binärer Suche.
	public static void insertionSortBinary(int[] array){
		int anzahlDerVertauschungen = 0;
		int anzahlDerVergleiche = 0;
		
		for (int i = 1; i < array.length; i++){
			int oldValue = array[i];
			
			int targetPosition = searchBinary(array, oldValue, 0, i - 1);	// oldValue oder array[i]
				
				for (int j = i; j > targetPosition; j--){
					array[j] = array[j - 1];
					anzahlDerVertauschungen++;
				}	
		}
		ausgabeInsertionSortBinary(array, anzahlDerVertauschungen, anzahlDerVergleiche);
		return;
	}
	
// Binäre Suche	
	public static int searchBinary(int[] targetArray, int searchInt, int bereichAnfang, int bereichEnde) {
		int i = 0;
		while(bereichAnfang <= bereichEnde){
				
			i = ((bereichEnde - bereichAnfang) / 2) + bereichAnfang;
			
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
		return bereichAnfang;
	}	
}
