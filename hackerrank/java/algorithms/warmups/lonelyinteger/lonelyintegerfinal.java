import java.util.*;

public class LonelyIntegerFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numIntegers = Integer.parseInt(scanner.nextLine());
        String integers = scanner.nextLine();
        String[] integersSplit = integers.split(" ");
        int result = 0;
        for(int i = 0; i < numIntegers; ++i){
        	result = result ^ Integer.parseInt(integersSplit[i]);
        }
        System.out.println(result);
        scanner.close();
    }
}