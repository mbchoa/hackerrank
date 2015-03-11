import java.util.Scanner;

public class LoveLetter {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        loveLetter();
    }
    
    public static void loveLetter(){
        String[] loveLetters = getLoveLetters(stdin.nextInt());
        int[] numberOfReductionsInLetter = new int[loveLetters.length];
        for(int i = 0; i < loveLetters.length; ++i)
            numberOfReductionsInLetter[i] = calculateNumberOfReductions(loveLetters[i]);
        for(int j = 0; j < numberOfReductionsInLetter.length; ++j)
            System.out.println(numberOfReductionsInLetter[j]);
    }
    
    public static String[] getLoveLetters(int numLetters){
        String[] loveLetters = new String[numLetters];
        for(int i = 0; i < numLetters; ++i){
            loveLetters[i] = stdin.next();
        }
        return loveLetters;
    }
    
    public static int calculateNumberOfReductions(String input){
        int numReductions = 0;
        if(!isPalindromeRecursive(input)){
            char frontChar = input.charAt(0);
            char backChar = input.charAt(input.length()-1);
            numReductions = Math.abs(frontChar-backChar) + calculateNumberOfReductions(input.substring(1, input.length()-1));
        }
        return numReductions;
    }
    
    public static Boolean isPalindrome(String input){
        int frontIndex = 0;
        int backIndex = input.length()-1;
        while(frontIndex <= backIndex){
            char frontChar = input.charAt(frontIndex);
            char backChar = input.charAt(backIndex);
            if(frontChar != backChar){
                return false;
            }
            ++frontIndex;
            --backIndex;
        }
        return true;
    }

    public static Boolean isPalindromeRecursive(String input){
        if(input.length() == 0 || input.length() == 1)
            return true;
        if(input.charAt(0) == input.charAt(input.length()-1))
            return isPalindromeRecursive(input.substring(1, input.length()-1));
        return false;
    }
}