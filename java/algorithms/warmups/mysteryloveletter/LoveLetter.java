import java.util.Scanner;

public class LoveLetter {
    private static Scanner stdin = new Scanner(System.in);
    
    public static void main(String[] args) {
        loveLetter();
    }
    
    public static void loveLetter(){
        String[] loveLetters = getLoveLetters(stdin.nextInt());
        for(int i = 0; i < loveLetters.length; ++i)
            System.out.println(calculateNumberOfReductions(loveLetters[i]));
    }
    
    public static String[] getLoveLetters(int numLetters){
        String[] loveLetters = new String[numLetters];
        for(int i = 0; i < numLetters; ++i){
            loveLetters[i] = stdin.next();
        }
        return loveLetters;
    }
    
    public static int calculateNumberOfReductions(String input){
        char[] inputCharArr = input.toCharArray();
        int numReductions = 0;
        int frontIndex = 0;
        int backIndex = input.length()-1;
        while(frontIndex <= backIndex){
            char frontChar = inputCharArr[frontIndex];
            char backChar = inputCharArr[backIndex];
            numReductions += abs(frontChar-backChar);
            ++frontIndex;
            --backIndex;
        }
        return numReductions;
    }
    
    public static int abs(int value){
        int mask = value>>31;
        return (value ^ mask) - mask;
    }
}