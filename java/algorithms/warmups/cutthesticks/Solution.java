package cutthesticks;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int N = stdin.nextInt();
		int[] stickLengthArr = getStickLengths(N);
		int[] sortedArr = countSort(stickLengthArr, findMax(stickLengthArr));
		
		while(sortedArr.length > 0){
			System.out.println(sortedArr.length);
			int minValue = sortedArr[0];
			int substringStartIndex = 0;
			for(int i = 0; i < sortedArr.length; ++i){
				sortedArr[i] -= minValue;
				if(sortedArr[i] == 0)
					substringStartIndex = i+1;
			}
			sortedArr = Arrays.copyOfRange(sortedArr, substringStartIndex, sortedArr.length);
		}
	}
	
	private static int[] getStickLengths(int numSticks){
		int[] output = new int[numSticks];
		for(int i = 0; i < numSticks; ++i)
			output[i] = stdin.nextInt();
		return output;
	}
	
	private static int[] countSort(int[] unsortedArr, int maxValue){
		int[] storage = new int[maxValue];
		for(int i = 0; i < unsortedArr.length; ++i)
			storage[unsortedArr[i]]++;
		for(int j = 1; j < storage.length; ++j)
			storage[j] = storage[j-1] + storage[j];
		int[] output = new int[unsortedArr.length];
		for(int i = unsortedArr.length-1; i >= 0; --i){
			output[--storage[unsortedArr[i]]] = unsortedArr[i];
		}
		return output;
	}
	
	private static int findMax(int[] array){
		int max = 0;
		for(int i = 0; i < array.length; ++i)
			if(array[i] > max)
				max = array[i];
		return max;
	}

}
