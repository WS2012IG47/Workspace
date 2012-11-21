package uebung03;

import static gdi.MakeItSimple.*;

public class searchFunctionsPerformanceTest {

	public static void main(String[] args) {

		int Arraygröße = 2048;

		println("Statistische Testreihe zur ermittlung der durschnittlichen Anzahl vergleiche bei verschiedenen SucheAlgorithmen.");
		println("Die Daten wurden aus 7500 automatisierten Testläufen ermittelt.");
		println();
		println("sequentielle suche (letzter Index) | sequentielle suche (erster Index) | binäre suche rekursiv implementiert | binäre suche iterativ implementiert");

		for (int i2 = 0; i2 < 3; i2++) {
			int[] testArray = new int[Arraygröße];
			for (int i = 0; i < testArray.length; i++) {
				testArray[i] = i;
			}

			int int1 = 0, int2 = 0, int3 = 0, int4 = 0;

			for (int i = 0; i < 7500; i++) {
				int testNumber = (int) Math.floor(Math.random() * testArray.length);

				int1 += searchLastIndex(testArray, testNumber);
				int2 += searchFirstIndex(testArray, testNumber);
				int3 += searchBinaryRecursive(testArray, testNumber, 0, testArray.length, 0);
				int4 += searchBinary(testArray, testNumber, 0, testArray.length);
			}
			int1 /= 7500;
			int2 /= 7500;
			int3 /= 7500;
			int4 /= 7500;

			println("Testergebnisse bei einer Arraygröße von:" + Arraygröße + " = " + int1 + " | " + int2 + " | " + int3 + " | " + int4);

			Arraygröße = Arraygröße * 2;
		}
	}

	public static int searchLastIndex(int[] targetArray, int searchNumber) {
		int vergleichzähler = 0;

		for (int i = 0; i < targetArray.length; i++) {
			vergleichzähler++;
		}

		return vergleichzähler;
	}

	public static int searchFirstIndex(int[] targetArray, int searchNumber) {
		int vergleichzähler = 0;

		for (int i = 0; i < targetArray.length; i++) {
			vergleichzähler++;
			if (targetArray[i] == searchNumber) {
				return vergleichzähler;
			}
		}

		return vergleichzähler;
	}

	public static int searchBinaryRecursive(int[] targetArray, int searchInt,
			int bereichAnfang, int bereichEnde, int vergleichzähler) {

		int i = ((bereichEnde - bereichAnfang) / 2) + bereichAnfang;

		if (bereichAnfang > bereichEnde) {
			return vergleichzähler;
		}
		vergleichzähler++;
		if (targetArray[i] == searchInt) {
			return vergleichzähler;
		}
		if (targetArray[i] < searchInt) {
			return searchBinaryRecursive(targetArray, searchInt, i + 1,
					bereichEnde, vergleichzähler);
		}
		if (targetArray[i] > searchInt) {
			return searchBinaryRecursive(targetArray, searchInt, bereichAnfang,
					i - 1, vergleichzähler);
		}

		return vergleichzähler;
	}

	public static int searchBinary(int[] targetArray, int searchInt,
			int bereichAnfang, int bereichEnde) {

		int vergleichzähler = 0;

		while (bereichAnfang <= bereichEnde) {

			int i = ((bereichEnde - bereichAnfang) / 2) + bereichAnfang;

			vergleichzähler++;
			if (targetArray[i] == searchInt) {
				return vergleichzähler;
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
