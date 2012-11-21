package uebung03;

import static gdi.MakeItSimple.*;

public class InsertionSortBinaer {

	public static void main(String[] args) {
		int array[] = new int[10];
		int i, z, p, k;
		i = z = p = k = 0;
		int newValue, anzahlDerVertauschungen, anzahlDerVergleiche;
		anzahlDerVertauschungen = anzahlDerVergleiche = 0;
		
// Schleife zum Befüllen des Arrays mit zufälligen Zahlen.
		while (i < array.length) {
			array[i] = (int) Math.floor(Math.random() * array.length);
			i++;
		}
	// Ausgabe der generierten unsortierten Folge.	
		while (z < array.length){
			print(array[z] + " ");
			z++;
		}
		println();
		
// Insertion Sort		
		i = 1;
		while (i < array.length) {
			newValue = array[i];
			anzahlDerVergleiche++;
			k = gesuchtePositionInArray(array, newValue, 0, array.length);
						
			array[k] = newValue;			
			i++;
			
	// Ausgabe des aktuellen Zustands der Folge nach jeder Veränderung.		
			while (p < array.length){
				print(array[p] + " ");
				p++;
			}
			println();
			p = 0;
		}
		println();

// Schleife zur Ausgabe des sortierten Arrays.
		i = 0;
		while (i < array.length) {
			print(array[i]);
			i++;
		}
		println();
		println();
		println("Anzahl Der Vergleiche: " + anzahlDerVergleiche);
		println("Anzahl Der Vertauschungen: " + anzahlDerVertauschungen); 
	}
	
// Binäre Suche	
		public static int gesuchtePositionInArray(int[] targetArray, int searchInt, int bereichAnfang, int bereichEnde) {

			int i = ((bereichEnde - bereichAnfang) / 2) + bereichAnfang;

			if (bereichAnfang > bereichEnde) {
				return -1;
			}
			if (targetArray[i] > searchInt && targetArray[i-1] <= searchInt) {
				return i;
			}
			if (targetArray[i] < searchInt) {
				return gesuchtePositionInArray(targetArray, searchInt, i + 1, bereichEnde);
			}
			if (targetArray[i] > searchInt) {
				return gesuchtePositionInArray(targetArray, searchInt, bereichAnfang, i - 1);
			}

			return -1;

		}
}