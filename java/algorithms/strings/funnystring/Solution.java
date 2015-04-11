package funnystring;

import java.util.Scanner;

public class Solution {
	public static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int T = stdin.nextInt();
		for(int i = 0; i < T; i++){
			System.out.println(isFunnyString(stdin.next()));
		}
	}

	private static String isFunnyString(String string){
		char[] stringArr = string.toCharArray();
		char[] reverseStringArr = reverseString(stringArr);
		for(int i = 1; i < stringArr.length; i++){
			if(Math.abs(stringArr[i]-stringArr[i-1]) != Math.abs(reverseStringArr[i]-reverseStringArr[i-1])){
				return "Not Funny";
			}
		}
		return "Funny";
	}
	
	private static char[] reverseString(char[] string){
		char[] reverseStringArr = new char[string.length];
		int frontIndex = 0;
		int backIndex = string.length-1;
		while(frontIndex < string.length){
			reverseStringArr[frontIndex] = string[backIndex];
			frontIndex++;
			backIndex--;
		}
		return reverseStringArr;
	}
}
