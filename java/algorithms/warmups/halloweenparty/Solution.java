package halloweenparty;

import java.util.Scanner;

public class Solution {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numCases = stdin.nextInt();
		for(int i = 0; i < numCases; i++){
			int slices = stdin.nextInt();
			System.out.println(calculatePiecesFromSlices(slices));
		}
	}
	
	private static long calculatePiecesFromSlices(int slices){
		if(slices%2 > 0){
			long width = (int)(slices*0.5) + 1;
			long height = (int)(slices*0.5);
			return width*height;
		}else{
			long pieces = (long)Math.pow((int)slices*0.5, 2);
			return pieces;
		}
	}
	
}
