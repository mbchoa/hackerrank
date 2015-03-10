import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LonelyIntegerFirst {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args){
		int numIntegers = getNumberOfIntegers();
		String integerSet = getIntegerSet();
		String[] integerSetSplit = splitIntegerSet(integerSet);
		
		Map<Integer, Integer> integerFrequencyMap = new HashMap<Integer, Integer>();
        populateFrequencyMapWithSet(integerFrequencyMap, integerSetSplit, numIntegers);
        
        System.out.println(findLonelyIntegerFromMap(integerFrequencyMap));
	}
	
	private static int findLonelyIntegerFromMap(Map<Integer, Integer> frequencyMap){
		int lonelyInteger = 0;
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet())
		{
			if(entry.getValue() == 1)
			{
				lonelyInteger = entry.getKey();
				break;
			}
		}
		return lonelyInteger;
	}
	
	private static void populateFrequencyMapWithSet(Map<Integer, Integer> frequencyMap, String[] integerSet, int numIntegers){
        for(int i = 0; i < numIntegers; ++i){
			int integerKey = Integer.parseInt(integerSet[i]);
			int numIntegerOccurrence;
			try{
				numIntegerOccurrence = (int)frequencyMap.get(integerKey);
			}catch(NullPointerException e){
				numIntegerOccurrence = 0;
			}
			if(frequencyMap.containsKey(integerKey) == false){
				frequencyMap.put(integerKey, 1);
			}else{
				frequencyMap.put(integerKey, ++numIntegerOccurrence);
			}
		}
    }

	private static String[] splitIntegerSet(String integerSet) {
		if(integerSet != null){
			return integerSet.split(" ");
		}else{
			return null;
		}
	}

	private static int getNumberOfIntegers(){
		return Integer.parseInt(stdin.nextLine());
	}
	
	private static String getIntegerSet(){
		return stdin.nextLine();
	}
}
