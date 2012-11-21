package uebung03;

import static gdi.MakeItSimple.*;

public class InsertionSort {

	public static void main(String[] args) {
		int array[] = new int[14];
		int i = 0;
		int z = 0;
		int p = 0;
		int j, newValue, anzahlDerVertauschungen, anzahlDerVergleiche;
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
			j = i;
			anzahlDerVergleiche++;
			while (j > 0 && array[j - 1] > newValue) {
				array[j] = array[j - 1];
				j--;
				anzahlDerVertauschungen++;
			}
			array[j] = newValue;			
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
}
