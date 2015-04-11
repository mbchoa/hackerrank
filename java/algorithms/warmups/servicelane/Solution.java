package servicelane;

import java.util.Scanner;

public class Solution {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args){
		int freewayLength = stdin.nextInt();
		int numCases = stdin.nextInt();
		int[] laneSegmentsWidth = new int[freewayLength];
		for(int i = 0; i < freewayLength; i++)
			laneSegmentsWidth[i] = stdin.nextInt();
		for(int j = 0; j < numCases; j++){
			int entryIndex = stdin.nextInt();
			int exitIndex = stdin.nextInt();
			int maxWidth = laneSegmentsWidth[entryIndex];
			for(int k = entryIndex+1; k <= exitIndex; k++){
				if(laneSegmentsWidth[k] < maxWidth)
					maxWidth = laneSegmentsWidth[k];
			}
			System.out.println(maxWidth);
		}
	}
}
