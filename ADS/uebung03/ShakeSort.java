package uebung03;

import static gdi.MakeItSimple.*;

public class ShakeSort {

	public static void main(String[] args) {
		int[] testArray = new int[10];
		print("Array mit zufälligen Zahlen von 0 bis 100: ");
		for (int i = 0; i < testArray.length; i++) {
			testArray[i] = (int) Math.floor(Math.random() * (100));
			print(testArray[i] + " ");
		}
		shakeSort(testArray);
		println("");
		print("Das Array, jetzt mit den sortierten Zahlen: ");
		for (int i = 0; i < testArray.length; i++)
			print(testArray[i] + " ");

	}

	public static void shakeSort(int[] targetArray) {
		boolean unsortiert = true;
		int temp;

		while (unsortiert) {
			unsortiert = false;
			for (int i = 0; i < targetArray.length - 1; i++)
				if (targetArray[i] > targetArray[i + 1]) {
					temp = targetArray[i];
					targetArray[i] = targetArray[i + 1];
					targetArray[i + 1] = temp;
					unsortiert = true;
				}
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
