import java.util.*;

public class AlternatingCharacters {

    private static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) {
        int numCases = stdin.nextInt();
        String[] cases = getCases(numCases);
        for(int i = 0; i < cases.length; ++i){
        	System.out.println(calculateNumDeletionsInCase(cases[i]));
        }
        
    }
    
    private static String[] getCases(int numCases){
    	String[] output = new String[numCases];
        for(int i = 0; i < numCases; ++i){
            String inputCase = stdin.next();
            output[i] = inputCase;
        }
        return output;
    }
    
    private static int calculateNumDeletionsInCase(String inputCase){
    	 String[] caseSplit = inputCase.split("");
         int numDeletions = 0;
         for(int j = 0; j < caseSplit.length-1; ++j){
             if(caseSplit[j].equals(caseSplit[j+1])){
                 numDeletions++;
             }
         }
         return numDeletions;
    }
}