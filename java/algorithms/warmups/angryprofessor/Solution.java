import java.util.*;

public class Solution {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        int numCases = stdin.nextInt();
        String[] outputs = new String[numCases];
        
        for(int i = 0; i < numCases; ++i){
        	int numStudents = stdin.nextInt();
        	int minimumStudentsOnTime = stdin.nextInt();
        	int numStudentsOnTime = 0;
        	for(int j = 0; j < numStudents; ++j){
        		int studentArrivalTime = stdin.nextInt();
        		if(studentArrivalTime <= 0)
        			numStudentsOnTime++;
        	}
        	if(numStudentsOnTime < minimumStudentsOnTime)
        		outputs[i] = "YES";
        	else
        		outputs[i] = "NO";
        }
        
        for(int i = 0; i < numCases; ++i){
        	System.out.println(outputs[i]);
        }
    }
}