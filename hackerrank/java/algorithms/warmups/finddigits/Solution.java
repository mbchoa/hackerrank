package finddigits;

import java.util.Scanner;

public class Solution {
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int numCases = stdin.nextInt();
		for(int i = 0; i < numCases; i++){
			int integer = stdin.nextInt();
			int numDigitsDivisibleFromInteger = getNumDigitsDivisibleFromInteger(integer);
			System.out.println(numDigitsDivisibleFromInteger);
		}
	}

	private static int getNumDigitsDivisibleFromInteger(int integer){
		int numDigitsDivisibleFromInteger = 0;
		int numDigits = getNumDigitsInInteger(integer);
		int currentInteger = integer;
		for(int j = 0; j < numDigits; j++){
			int digit = currentInteger % 10;
			if(isIntegerDivisibleByValue(integer, digit) == true)
				++numDigitsDivisibleFromInteger;
			currentInteger /= 10;
		}
		return numDigitsDivisibleFromInteger;
	}
	
	private static int getNumDigitsInInteger(int integer){
		return (int)(Math.log(integer) / Math.log(10) + 1);
	}
	
	private static Boolean isIntegerDivisibleByValue(int integer, int value){
		return (value > 0) && (integer%value == 0);
	}
}
