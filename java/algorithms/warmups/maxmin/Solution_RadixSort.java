package maxmin;

import java.util.*;

public class Solution {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args){
        maxmin();
    }
    
    private static void maxmin(){
        int N = getIntFromStdin();
        int K = getIntFromStdin();
        int[] inputsList = getInputs(N);
        
        int minimumFairness = calculateFairnessFromKSizeSublist(inputsList, K);
        System.out.println(minimumFairness);
    }
    
    private static int getIntFromStdin(){
        return stdin.nextInt();
    }
    
    private static int[] getInputs(int size){
        int[] inputsList = new int[size];
        for(int i = 0; i < size; ++i)
            inputsList[i] = stdin.nextInt();
        return inputsList;
    }

    private static int calculateFairnessFromKSizeSublist(int[] inputsList, int K){
        int[] sortedList = radixSort(inputsList, getNumberOfDigits(getMaxNumberInArray(inputsList)));
        int minimumFairness = calculateFairnessFromSortedList(Arrays.copyOfRange(sortedList, 0, K));
        for(int i = 1; i < sortedList.length-K; ++i){
            int currentFairness = calculateFairnessFromSortedList(Arrays.copyOfRange(sortedList, i, i+K));
            if(currentFairness < minimumFairness)
                minimumFairness = currentFairness;
        }
        return minimumFairness;
    }

    private static int getMaxNumberInArray(int[] array){
        int max = 0;
        for(int i = 0; i < array.length; ++i)
            if(array[i] > max)
                max = array[i];
        return max;
    }
                                     
    private static int getNumberOfDigits(int number){
        return String.valueOf(number).length();
    }
    
    private static int[] radixSort(int[] unsortedArr, int digits){
		for(int i = 1; i <= digits; ++i){
			unsortedArr = countSort(unsortedArr, 10, (int)Math.pow(10, i));
		}
		return unsortedArr;
	}
	
	private static int[] countSort(int[] unsortedArr, int base, int digit){
		int[] keyArray = new int[base];
		
		for(int i = 0; i < unsortedArr.length; ++i)
			keyArray[(unsortedArr[i] / (digit/base)) % base]++;
		for(int j = 1; j < keyArray.length; ++j)
			keyArray[j] += keyArray[j-1];
		 
		int[] sortedArr = new int[unsortedArr.length];
		for(int i = unsortedArr.length-1; i >= 0; --i){
			sortedArr[keyArray[(unsortedArr[i] / (digit/base)) % base]-1] = unsortedArr[i];
			keyArray[(unsortedArr[i] / (digit/base)) % base] -= 1;
		}
		return sortedArr;
	}
	
    private static int calculateFairnessFromSortedList(int[] list){
        return list[list.length-1] - list[0];
    }
}
