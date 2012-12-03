package uebung04;
import static gdi.MakeItSimple.*;

public class Shellsort {

	public static void main(String[] args) {
		
		int[] array = new int[20];

		for (int i = 0; i < array.length; i++){
			array[i] = (int)Math.floor(Math.random() * array.length);
		}
		for (int i = 0; i < array.length; i++){
			print(array[i] + " ");
		}
		println();
		shellsort(array);
	}
	
	public static void shellsort(int[] array){
		int[] arrayCount = {9, 7, 4, 1};

		for (int ac = 0; ac < arrayCount.length; ac++){
			println();
			println("h = " + arrayCount[ac]);
			
		for (int i = 0; i+arrayCount[ac] < array.length; i++){
			int value1 = array[i];
			int value2 = array[i+arrayCount[ac]];
			
		
				if (value2 < array[i] && i >= arrayCount[ac] && arrayCount[ac] != 1){

					int value3 = 0;
					int c = i - arrayCount[ac];
					boolean moreChanges = false;
					
					while (c >= 0 && value2 < array[c]){
						moreChanges = true;
						value3 = array[c];
						c -= arrayCount[ac];
					}
					if (moreChanges){
						array[c+arrayCount[ac]] = value2;
						array[i+arrayCount[ac]] = value3;
					}
					if (!moreChanges){
						array[i] = value2;
						array[i+arrayCount[ac]] = value1;
					}
				} 
				
				if (arrayCount[ac] == 1){

					while (i > 0 && value2 < array[i]){
						array[i+arrayCount[ac]] = array[i];
						array[i] = value2;
						i--;		
					}					
				}
				
				if (value2 < array[i] && i < arrayCount[ac]){
					array[i] = value2;
					array[i+arrayCount[ac]] = value1;
				}
			
			println();
			for (int p = 0; p < array.length; p++){
				print(array[p] + " ");
			}
			println();
		}
		
		
	}
	}
}
