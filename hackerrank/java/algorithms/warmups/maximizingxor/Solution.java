import java.util.*;

public class Solution {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        maxor();
    }
    
    private static void maxor(){
        int L = stdin.nextInt();
        int R = stdin.nextInt();
        
        int maxXorValue = 0;
        for(int firstFactor = L; firstFactor <= R; ++firstFactor){
            for(int secondFactor = firstFactor; secondFactor <= R; ++secondFactor){
                int curXorValue = firstFactor ^ secondFactor;
                if(curXorValue > maxXorValue)
                    maxXorValue = curXorValue;
            }
        }
        System.out.println(maxXorValue);
    }
}
