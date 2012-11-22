package uebung03;

import static gdi.MakeItSimple.*;

public class InsertionSortBinaer {

	public static void main(String[] args) {
		int array[] = new int[10];
		int oldValue, anzahlDerVertauschungen, anzahlDerVergleiche;
		anzahlDerVertauschungen = anzahlDerVergleiche = 0;
		
// Schleife zum Befüllen des Arrays mit zufälligen Zahlen.
		for (int i = 0; i < array.length; i++){
			array[i] = (int) Math.floor(Math.random() * array.length);
			i++;
		}
		
	// Ausgabe der generierten unsortierten Folge.	
		for (int i = 0; i < array.length; i++){
			print(array[i] + " ");
			}
		println();
		
		
// Insertion Sort		
		for (int i = 1; i < array.length; i++){
			oldValue = array[i];
			
			int targetPosition = searchBinary(array, array[i], 0, i - 1);
			
			for (int j = i; j > targetPosition; j--){
				array[j] = array[j - 1]; 
				anzahlDerVertauschungen++;
			}
			array[targetPosition] = oldValue;
			anzahlDerVertauschungen++;
			
	// Ausgabe des aktuellen Zustands der Folge nach jeder Veränderung.		
			for (int i2 = 0; i2 < array.length; i2++){
				print(array[i2] + " ");
			}
			println();
		}
		println();

// Schleife zur Ausgabe des sortierten Arrays.
		for (int i = 0; i < array.length; i++){
			print(array[i]);
			i++;
		}
		println();
		println();
		println("Anzahl Der Vergleiche: " + anzahlDerVergleiche);
		println("Anzahl Der Vertauschungen: " + anzahlDerVertauschungen); 
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
		return i;
	}
}