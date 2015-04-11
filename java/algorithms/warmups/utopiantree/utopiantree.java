import java.util.*;

public class UtopianTree {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        int numCases = stdin.nextInt();
        List<Integer> cases = getCases(numCases);
        processCases(cases);
    }
    
    private static List<Integer> getCases(int numCases){
        List<Integer> cases = new ArrayList<Integer>();
        for(int i=0; i < numCases; ++i){
            cases.add(stdin.nextInt());
        }
        return cases;
    }
    
    private static void processCases(List<Integer> cases){
        for(int i=0; i < cases.size(); ++i){
            System.out.println(calculateTreeHeightByCycles(cases.get(i)));
        }
    }
    
    private static int calculateTreeHeightByCycles(int cycles){
        int numYearsElapsed = cycles / 2;
        int overflow = cycles % 2;
        int calculatedTreeHeight = 1;
        for(int i=0; i<numYearsElapsed; ++i){
            calculatedTreeHeight = calculatedTreeHeight * 2 + 1;
        }
        if(overflow > 0){
            calculatedTreeHeight *= 2;
        }
        return calculatedTreeHeight;
    }
}