import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlippingBits {
	private static final long maxInt = (long)Math.pow(2, 32) - 1;
	private static Scanner stdin = new Scanner(System.in);
	
	public static void main(String[] args) {
		int listSize = getListSize();
		processIntegerList(listSize);
	}
	
	private static int getListSize(){
		return Integer.parseInt(stdin.nextLine());
	}
	
	private static void processIntegerList(int listSize){
		List<Long> integerInputs = getIntegerInputs(listSize);
		flipIntegerList(integerInputs);
		printList(integerInputs);
	}
	
	private static List<Long> getIntegerInputs(int listSize){
		List<Long> integerInputs = new ArrayList<Long>();
		for(int i=0; i<listSize;++i){
			integerInputs.add(Long.parseLong(stdin.nextLine()));
		}
		return integerInputs;
	}
	
	private static void flipIntegerList(List<Long> integerInputs){
		for(int i=0; i<integerInputs.size(); ++i){
			integerInputs.set(i, flipInteger(integerInputs.get(i)));
		}
	}
	
	private static long flipInteger(long num){
	    return maxInt - num;
	}
	
	private static void printList(List<Long> integerList){
		for(int i=0; i<integerList.size(); ++i){
			System.out.println(integerList.get(i));
		}
	}
}
