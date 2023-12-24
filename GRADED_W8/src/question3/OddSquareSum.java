package question3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OddSquareSum {
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		System.out.println("Input: " + Arrays.toString(arr));
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i : arr) {
			al.add(i);
		}
		
		// finding odd using filter
		List<Integer> oddList = al.stream().filter(temp -> temp%2 != 0).toList();
		System.out.println("Odd Numbers: " + oddList);
		
		// finding squares using map
		List<Integer> squareList = oddList.stream().map(temp -> temp*temp).toList();
		System.out.println("Squares: " + squareList);
		
		// finding sum
		System.out.println("Sum: " + squareList.stream().mapToInt(temp -> temp).sum());
		
	}
	
}
