package isfibo;

import java.util.Scanner;

public class Solution {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numCases = stdin.nextInt();
		solve(numCases);
	}

	private static void solve(int numCases){
		for(int i = 0; i < numCases; i++){
			long input = stdin.nextLong();
			printAnswer(isFibo(input));
		}
	}
	
	private static Boolean isFibo(long integer){
		Boolean isFibo = false;
		long previousFibo = 0;
		long currentFibo = 1;
		if(integer == previousFibo || integer == currentFibo){
			isFibo = true;
		}else{
			while(currentFibo <= integer){
				if(currentFibo == integer){
					isFibo = true;
					break;
				}
				long nextFibo = currentFibo + previousFibo;
				previousFibo = currentFibo;
				currentFibo = nextFibo;
			}
		}
		
		return isFibo;
	}
	
	private static void printAnswer(Boolean isFibo){
		if(isFibo) System.out.println("IsFibo");
		else System.out.println("IsNotFibo");
	}
}
