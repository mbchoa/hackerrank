package fillingjars;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        long numJars = stdin.nextLong();
        long numOperations = stdin.nextLong();
        long sum = 0;
        for(int i = 0; i < numOperations; i++){
        	long firstJarIndex = stdin.nextLong();
        	long lastJarIndex = stdin.nextLong();
        	long numCandies = stdin.nextLong();
            sum += (lastJarIndex-firstJarIndex+1) * numCandies;
        }
        long average = (long)Math.floor(sum / numJars);
        System.out.println(average);
    }
}