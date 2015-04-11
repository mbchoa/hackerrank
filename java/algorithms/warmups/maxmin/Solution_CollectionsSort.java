import java.util.*;

public class Solution {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args){
        maxmin();
    }
    
    private static void maxmin(){
        int N = getIntFromStdin();
        int K = getIntFromStdin();
        List<Integer> inputsList = getInputs(N);
        
        int minimumFairness = calculateFairnessFromKSizeSublist(inputsList, K);
        System.out.println(minimumFairness);
    }
    
    private static int getIntFromStdin(){
        return stdin.nextInt();
    }
    
    private static List<Integer> getInputs(int size){
        List<Integer> inputsList = new ArrayList<Integer>();
        for(int i = 0; i < size; ++i)
            inputsList.add(stdin.nextInt());
        return inputsList;
    }

    private static int calculateFairnessFromKSizeSublist(List<Integer> inputsList, int K){
        Collections.sort(inputsList);
        int minimumFairness = calculateFairnessFromList(inputsList.subList(0, K));
        for(int i = 1; i < inputsList.size()-K; ++i){
            int currentFairness = calculateFairnessFromList(inputsList.subList(i, i+K));
            if(currentFairness < minimumFairness)
                minimumFairness = currentFairness;
        }
        return minimumFairness;
    }
    
    private static int calculateFairnessFromList(List<Integer> list){
        return maxValueInList(list) - minValueInList(list);
    }
                                              
    private static int maxValueInList(List<Integer> list){
        return Collections.max(list);
    }
    
    private static int minValueInList(List<Integer> list){
        return Collections.min(list);
    }
}
