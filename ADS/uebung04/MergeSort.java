package uebung04;

import static gdi.MakeItSimple.*;

/*
 * Gruppe 4 - 7
 * Philip Dombrowski, Matrikelnummer: 1220235
 * Tobias Kunz, Matrikelnummer: 1232749
 * Timm Dobhan, Matrikelnummer: 1232995
 */

// quellband = sourceFile
// hilfsbandEins = helpFileOne
// helpFileTwo = helpFileTwo
// lauflength = runlength
// helpFileTwoZähler = helpFileTwoCounter
// länge = length
// ausgabelength = printlength
// ausgabeBand = outputFile

public class MergeSort {

	public static void main(String[] args) {
		println("Bitte geben sie den Pfad zu dem Ordner welcher die Dateien \"numbers.txt\", \"helpFileOne.txt\" und \"helpFileTwo.txt\" enthält"); 
		String source = readLine();
		
		String filePath = source + "/numbers.txt";
		int countedNumbers = (IntReader.countInt(filePath));
		println("Anzahl der Nummern: " + countedNumbers);
		
		mergeSort(source, countedNumbers);
		
	}
	// /Users/Padombar/Dropbox/Informatik/workspace/GIT/ADS/uebung04
	public static void mergeSort(String filePath, int countedNumbers)
	{	
		// Windows Schreibweise
//		String filename1 = filePath + "\\numbers.txt";
//		String filename2 = filePath + "\\helpFileOne.txt";
//		String filename3 = filePath + "\\helpFileTwo.txt";

		// Mac Schreibweise
		String filename1 = filePath + "/numbers.txt";
		String filename2 = filePath + "/helpFileOne.txt";
		String filename3 = filePath + "/helpFileTwo.txt";

		if (!isFilePresent(filename1)) {
			println("Hey, die Datei: " + filename1 + " fehlt!");
			return;
		}
		if (!isFilePresent(filename2)) {
			println("Hey, die Datei: " + filename2 + " fehlt!");
			return;
		}
		if (!isFilePresent(filename2)) {
			println("Hey, die Datei: " + filename3 + " fehlt!");
			return;
		}
			Object sourceFile;
			Object helpFileOne;
			Object helpFileTwo;

			for (int runlength = 1; runlength < countedNumbers; runlength = runlength * 2) {
				IntReader sourceFileReader = new IntReader(filename1);
				helpFileOne = openOutputFile(filename2);
				helpFileTwo = openOutputFile(filename3);

				split(runlength, sourceFileReader, helpFileOne, helpFileTwo);

				sourceFileReader.closeIntReader();
				closeOutputFile(helpFileOne);
				closeOutputFile(helpFileTwo);

					sourceFile = openInputFile(filename2);
					printTape(sourceFile, '*', runlength, 25);
					closeInputFile(sourceFile);
				
					sourceFile = openInputFile(filename3);
					printTape(sourceFile, '*', runlength, 25);
					closeInputFile(sourceFile);
				
				sourceFile = openOutputFile(filename1);
				IntReader helpFileOneReader = new IntReader(filename2);
				IntReader helpFileTwoReader = new IntReader(filename3);

				merge(runlength, sourceFile, helpFileOneReader, helpFileTwoReader);

				closeOutputFile(sourceFile);
				helpFileOneReader.closeIntReader();
				helpFileTwoReader.closeIntReader();

					sourceFile = openInputFile(filename1);
					printTape(sourceFile, '*', runlength * 2, 25);
					closeInputFile(sourceFile);
					println();
		}
	}

	public static void merge(int runlength, Object sourceFile, IntReader helpFileOne, IntReader helpFileTwo) {
		while (onePartOfMerge(runlength, sourceFile, helpFileOne, helpFileTwo));
	}

	public static boolean onePartOfMerge(int runlength, Object sourceFile, IntReader helpFileOne, IntReader helpFileTwo) {
		int helpFileOneCounter = 0;
		int helpFileTwoCounter = 0;

		while (true) {

			// ---------> Band1 EOF
			if (!helpFileOne.isNumberAvailable()) {
				while (helpFileTwo.isNumberAvailable()) {
					print(sourceFile, "  ");
					print(sourceFile, helpFileTwo.readAndNextNumber());
				}
				return false;
			}
			// <--------- Band1 EOF

			// ---------> Band1 EOS
			if (!(helpFileOneCounter < runlength)) {
				while (helpFileTwoCounter < runlength) {
					print(sourceFile, "  ");
					print(sourceFile, helpFileTwo.readAndNextNumber());
					helpFileTwoCounter++;
				}
				return true;

			}
			// <--------- Band1 EOS

			// ---------> Band2 EOF
			if (!helpFileTwo.isNumberAvailable()) {
				while (helpFileOne.isNumberAvailable()) {
					print(sourceFile, "  ");
					print(sourceFile, helpFileOne.readAndNextNumber());
				}

				return false;
			}
			// <--------- Band2 EOF

			// ---------> Band2 EOS
			if (!(helpFileTwoCounter < runlength)) {
				while (helpFileOneCounter < runlength) {
					print(sourceFile, "  ");
					print(sourceFile, helpFileOne.readAndNextNumber());
					helpFileOneCounter++;
				}
				return true;
			}
			// <--------- Band2 EOS

			if (helpFileOne.readNumber() <= helpFileTwo.readNumber()) {
				print(sourceFile, "  ");
				print(sourceFile, helpFileOne.readAndNextNumber());
				helpFileOneCounter++;
			} 
			else 
			{
				print(sourceFile, "  ");
				print(sourceFile, helpFileTwo.readAndNextNumber());
				helpFileTwoCounter++;
			}
		}
	}

// Split method
	public static void split(int runlength, IntReader sourceFile, Object helpFileOne, Object helpFileTwo) {
		boolean bandauswahl = true;

		while (sourceFile.isNumberAvailable()) {
			if (bandauswahl) {
				for (int i = 0; i < runlength; i++) {
					if (sourceFile.isNumberAvailable()) {
						print(helpFileOne, " ");
						print(helpFileOne, sourceFile.readAndNextNumber());
					} else {
						return;
					}
				}

				bandauswahl = false;
			} else {
				for (int i = 0; i < runlength; i++) {
					if (sourceFile.isNumberAvailable()) {
						print(helpFileTwo, " ");
						print(helpFileTwo, sourceFile.readAndNextNumber());
					} else {
						return;
					}
				}
				bandauswahl = true;
			}
		}

	}

	public static void printTape(Object outputFile, char delimiter, int length, int printlength) {
		int i = 0;

		for(int i2 = 0; i2 < printlength  && !isEndOfInputFile(outputFile); i2++) {
			if (i == length) {
				print(delimiter);
				i = 0;
			}
			print(" " + readInt(outputFile) + " ");
			i++;
		}
		println();
	}

}