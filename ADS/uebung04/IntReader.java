package uebung04;
import static gdi.MakeItSimple.*;
public class IntReader {

	private Object Sourcefile;
	private boolean numberAvailable;
	private int number;
	
	public IntReader(String SourcefilePath)	{
		Sourcefile = openInputFile(SourcefilePath);
		
		if(isEndOfInputFile(Sourcefile)) {
			numberAvailable = false;
		} else {
			number = readInt(Sourcefile);
			numberAvailable = true;
		}
	}
	
	public static int countInt(String filePath){
		int countInt = 0;
		Object openFile = openInputFile(filePath);
		
		while (!isEndOfInputFile(openFile)){
			if (readChar(openFile) == ' ')
				countInt++;
		}
		closeInputFile(openFile);
		return countInt;
	}
	
	public int readAndNextNumber() {
		if(numberAvailable) {
			int tempNumber;
			
			if(isEndOfInputFile(Sourcefile)) {
				tempNumber = number;
				numberAvailable = false;
			} else {
				tempNumber = number;
				number = readInt(Sourcefile);
			}
			
			return tempNumber;
		}
		
		// Hier würde ein exeption geworfen werden wen wir das schon gelernt hätten.
		// Um das zu vermeiden kann mit isNumberAvailable geprüft werden ob eine zahl verfügbar ist.
		return Integer.MAX_VALUE;
	}
	
	public int readNumber()	{
		return number;
	}
	
	public void nextNumber() {
		if(!isEndOfInputFile(Sourcefile)) {
			number = readInt(Sourcefile);
		} else {
			// wir werden alle sterben!!!
		}
	}
	
	public boolean isNumberAvailable() {
		return numberAvailable;
	}
	
	public void closeIntReader() {
		closeInputFile(Sourcefile);
	}
}