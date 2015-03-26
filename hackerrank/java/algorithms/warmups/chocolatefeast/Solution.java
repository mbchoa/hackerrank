package chocolatefeast;

import java.util.Scanner;

public class Solution {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numCases = stdin.nextInt();
		for(int i = 0; i < numCases; i++){
			System.out.println(solve(stdin.nextInt(), stdin.nextInt(), stdin.nextInt()));
		}
	}
	
	private static int solve(int pocketMoney, int chocoPrice, int wrappersNeededForFree){
		int numChocolateBought = pocketMoney / chocoPrice;
		return numChocolateBought + chocolatesBoughtFromWrappers(numChocolateBought, wrappersNeededForFree);
	}
	
	private static int chocolatesBoughtFromWrappers(int numWrappers, int wrappersNeededForFree){
		int sum = 0;
		if(numWrappers >= wrappersNeededForFree)
			sum += chocolatesBoughtFromWrappers(numWrappers - wrappersNeededForFree + 1, wrappersNeededForFree) + 1;
		return sum;
	}

}
