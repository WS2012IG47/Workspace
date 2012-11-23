package uebung03;

import static gdi.MakeItSimple.*;

public class ShakeSort {

	public static void main(String[] args) {
		int[] testArray = new int[10];
		
// Array wird mit zufälligen Zahlen gefüllt und (unsortiert) ausgegeben		
		print("Array mit zufälligen Zahlen von 0 bis 100: ");
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = (int) Math.floor(Math.random() * (100));
			print(testArray[i] + " ");
		}
		
// Aufruf der Methode, welche die Zahlen im Array sortiert/ordnet
		shakeSort(testArray);
		println("");
		
//	 	Die Zahlen werden sortiert ausgegeben
		print("Das Array, jetzt mit den sortierten Zahlen: ");
		for (int i = 0; i < testArray.length; i++)
			print(testArray[i] + " ");

	}

// Methode zum sortieren von Zahlen via ShakeSort Algorithmus	
	public static void shakeSort(int[] targetArray) {
		boolean unsortiert = true;
		int temp;

		while (unsortiert) {
			unsortiert = false;
// Diese Schleife zählt von links nach rechts. Vergleicht Zahlen paarweise und vertauscht diese falls nötig		
			for (int i = 0; i < targetArray.length - 1; i++)
				if (targetArray[i] > targetArray[i + 1]) {
					temp = targetArray[i];
					targetArray[i] = targetArray[i + 1];
					targetArray[i + 1] = temp;
					unsortiert = true;
				}
// Diese Schleife zählt von rechts nach links. Vergleicht Zahlen paarweise und vertauscht diese falls nötig			
			for (int i = targetArray.length - 1; i > 0; i--)
				if (targetArray[i] < targetArray[i - 1]) {
					temp = targetArray[i];
					targetArray[i] = targetArray[i - 1];
					targetArray[i - 1] = temp;
					unsortiert = true;
				}
		}
	}

}
