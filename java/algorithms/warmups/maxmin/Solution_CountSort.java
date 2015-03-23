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
        int[] sortedList = countSort(inputsList);
        int minimumFairness = calculateFairnessFromSortedList(Arrays.copyOfRange(sortedList, 0, K));
        for(int i = 1; i < sortedList.length-K; ++i){
            int currentFairness = calculateFairnessFromSortedList(Arrays.copyOfRange(sortedList, i, i+K));
            if(currentFairness < minimumFairness)
                minimumFairness = currentFairness;
        }
        return minimumFairness;
    }
    
    public static int[] countSort(int[] inputArr){
		int maxNumber = max(inputArr);
		int[] buckets = createBuckets(maxNumber);

		for(int i = 0; i < inputArr.length; ++i)
			buckets[inputArr[i]]++;
		for(int j = 1; j < buckets.length; ++j)
			buckets[j] += buckets[j-1];

		int[] output = new int[inputArr.length];
		for(int k = inputArr.length-1; k >= 0; k--)
		{
		    output[buckets[inputArr[k]] - 1] = inputArr[k];
		    buckets[inputArr[k]]  = buckets[inputArr[k]] - 1;
		}

		return output;
	}
	
	public static int max(int[] inputArr){
		int max = 0;
		for(int i = 0; i < inputArr.length; ++i){
			if(inputArr[i] > max)
				max = inputArr[i];
		}
		return max;
	}
	
	private static int[] createBuckets(int maxBucketKey){
		return new int[maxBucketKey+1];
	}
	
    private static int calculateFairnessFromSortedList(int[] list){
        return list[list.length-1] - list[0];
    }
}
