package uebung04;

import static gdi.MakeItSimple.*;

/*
 * Gruppe 4 - 7
 * Philip Dombrowski, Matrikelnummer: 1220235
 * Tobias Kunz, Matrikelnummer: 1232749
 * Timm Dobhan, Matrikelnummer: 1232995
 */

public class MergeSort {

	public static void main(String[] args) {
		println("Bitte geben sie den Pfad zu dem Ordner welcher die Dateien \"numbers.txt\", \"hilfsbandEins.txt\" und \"hilfsbandZwei.txt\" enthält"); 
		String quelldateiPfad = readLine();
		
		String datei = quelldateiPfad + "/numbers.txt";
		int countedNumbers = (IntReader.countInt(datei));
		println("Anzahl der Nummern: " + countedNumbers);
		
		mergeSort(quelldateiPfad, countedNumbers);
		
	}
	// /Users/Padombar/Dropbox/Informatik/workspace/GIT/ADS/uebung04
	public static void mergeSort(String filePath, int countedNumbers)
	{	
		// Windows Schreibweise
//		String filename1 = filePath + "\\numbers.txt";
//		String filename2 = filePath + "\\hilfsbandEins.txt";
//		String filename3 = filePath + "\\hilfsbandZwei.txt";

		// Mac Schreibweise
		String filename1 = filePath + "/numbers.txt";
		String filename2 = filePath + "/hilfsbandEins.txt";
		String filename3 = filePath + "/hilfsbandZwei.txt";

		if (!isFilePresent(filename1)) {
			println("Hey die Datei: " + filename1 + " fehlt!");
			return;
		}
		if (!isFilePresent(filename2)) {
			println("Hey die Datei: " + filename2 + " fehlt!");
			return;
		}
		if (!isFilePresent(filename2)) {
			println("Hey die Datei: " + filename3 + " fehlt!");
			return;
		}
			Object quellband;
			Object hilfsbandEins;
			Object hilfsbandZwei;

			for (int lauflänge = 1; lauflänge < countedNumbers; lauflänge = lauflänge * 2) {
				IntReader quellbandReader = new IntReader(filename1);
				hilfsbandEins = openOutputFile(filename2);
				hilfsbandZwei = openOutputFile(filename3);

				split(lauflänge, quellbandReader, hilfsbandEins, hilfsbandZwei);

				quellbandReader.closeIntReader();
				closeOutputFile(hilfsbandEins);
				closeOutputFile(hilfsbandZwei);

					quellband = openInputFile(filename2);
					printTape(quellband, '*', lauflänge, 25);
					closeInputFile(quellband);
				
					quellband = openInputFile(filename3);
					printTape(quellband, '*', lauflänge, 25);
					closeInputFile(quellband);
				
				quellband = openOutputFile(filename1);
				IntReader hilfsbandEinsReader = new IntReader(filename2);
				IntReader hilfsbandZweiReader = new IntReader(filename3);

				merge(lauflänge, quellband, hilfsbandEinsReader, hilfsbandZweiReader);

				closeOutputFile(quellband);
				hilfsbandEinsReader.closeIntReader();
				hilfsbandZweiReader.closeIntReader();

					quellband = openInputFile(filename1);
					printTape(quellband, '*', lauflänge * 2, 25);
					closeInputFile(quellband);
					println();
		}
	}

	public static void merge(int lauflänge, Object quellband, IntReader hilfsbandEins, IntReader hilfsbandZwei) {
		while (onePartOfMerge(lauflänge, quellband, hilfsbandEins, hilfsbandZwei));
	}

	public static boolean onePartOfMerge(int lauflänge, Object quellband, IntReader hilfsbandEins, IntReader hilfsbandZwei) {
		int hilfsbandEinsZähler = 0;
		int hilfsbandZweiZähler = 0;

		while (true) {

			// ---------> Band1 EOF
			if (!hilfsbandEins.isNumberAvailable()) {
				while (hilfsbandZwei.isNumberAvailable()) {
					print(quellband, "  ");
					print(quellband, hilfsbandZwei.readAndNextNumber());
				}
				return false;
			}
			// <--------- Band1 EOF

			// ---------> Band1 EOS
			if (!(hilfsbandEinsZähler < lauflänge)) {
				while (hilfsbandZweiZähler < lauflänge) {
					print(quellband, "  ");
					print(quellband, hilfsbandZwei.readAndNextNumber());
					hilfsbandZweiZähler++;
				}
				return true;

			}
			// <--------- Band1 EOS

			// ---------> Band2 EOF
			if (!hilfsbandZwei.isNumberAvailable()) {
				while (hilfsbandEins.isNumberAvailable()) {
					print(quellband, "  ");
					print(quellband, hilfsbandEins.readAndNextNumber());
				}

				return false;
			}
			// <--------- Band2 EOF

			// ---------> Band2 EOS
			if (!(hilfsbandZweiZähler < lauflänge)) {
				while (hilfsbandEinsZähler < lauflänge) {
					print(quellband, "  ");
					print(quellband, hilfsbandEins.readAndNextNumber());
					hilfsbandEinsZähler++;
				}
				return true;
			}
			// <--------- Band2 EOS

			if (hilfsbandEins.readNumber() <= hilfsbandZwei.readNumber()) {
				print(quellband, "  ");
				print(quellband, hilfsbandEins.readAndNextNumber());
				hilfsbandEinsZähler++;
			} 
			else 
			{
				print(quellband, "  ");
				print(quellband, hilfsbandZwei.readAndNextNumber());
				hilfsbandZweiZähler++;
			}
		}
	}

	public static void split(int lauflänge, IntReader quellband, Object hilfsbandEins, Object hilfsbandZwei) {
		boolean bandauswahl = true;

		while (quellband.isNumberAvailable()) {
			if (bandauswahl) {
				for (int i = 0; i < lauflänge; i++) {
					if (quellband.isNumberAvailable()) {
						print(hilfsbandEins, " ");
						print(hilfsbandEins, quellband.readAndNextNumber());
					} else {
						return;
					}
				}

				bandauswahl = false;
			} else {
				for (int i = 0; i < lauflänge; i++) {
					if (quellband.isNumberAvailable()) {
						print(hilfsbandZwei, " ");
						print(hilfsbandZwei, quellband.readAndNextNumber());
					} else {
						return;
					}
				}
				bandauswahl = true;
			}
		}

	}

	public static void printTape(Object ausgabeBand, char delimiter, int länge, int ausgabelänge) {
		int i = 0;

		for(int i2 = 0; i2 < ausgabelänge  && !isEndOfInputFile(ausgabeBand); i2++) {
			if (i == länge) {
				print(delimiter);
				i = 0;
			}
			print(" " + readInt(ausgabeBand) + " ");
			i++;
		}
		println();
	}

}