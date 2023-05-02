package citi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * There is an array A consisting of N integers. What is the maximum sum of two
 * integers from A that share their first and last digits? For example, 1007 and
 * 167 share their first (1) and last (7) digits, whereas 2002 and 55 do not.
 * 		write a function 
 * 		class Solution { public int solution(int[] A); } 
 * 
 * that, given an array A consisting of N integers, returns the maximum sum of two integers
 * that share their first and last digits. If there are no two integers that
 * share their first and last digits, the function should return −1.
 * 
 * @author Adnan
 *
 */
public class MaxSumSolution {

	public int solution(int[] A) {
		// Implement your solution here
		Map<String, Integer> maxValues = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			String key = getFirstAndLastDigitPair(A[i]);

			if (maxValues.containsKey(key)) {
				int currentValue = maxValues.get(key);
				maxValues.put(key, Math.max(currentValue, A[i]));
				//System.out.println("Adding " + key + " " + Math.max(currentValue, A[i]));
			} else {
				maxValues.put(key, A[i]);
				//System.out.println("Adding: " + key + " " + A[i]);
			}
		}
		
		System.out.println("Max values: ");
		//maxValues.forEach((K,V) -> System.out.println(V));
		maxValues.values().stream().forEach(System.out::println);

		int maxSum = -1;
		for (int i = 0; i < A.length; i++) {
			String key = getFirstAndLastDigitPair(A[i]);
			if (maxValues.containsKey(key)) {
				int currentValue = maxValues.get(key);
				System.out.println(
						String.format("Iter array element %1d key %2s Current value %3d", A[i], key, currentValue));
				if (currentValue != A[i]) {
					System.out.println("prev MAx:" + maxSum + " cVal" + A[i]);
					maxSum = Math.max(maxSum, currentValue + A[i]);
					System.out.println("new Max:" + maxSum);
				}
			}
		}

		return maxSum;

	}

	private String getFirstAndLastDigitPair(int num) {
		String str = String.valueOf(num);
		return str.charAt(0) + "" + str.charAt(str.length() - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {140, 10, 300, 300, 120} ;
		
		System.out.println("Given array: " + Arrays.toString(A));
		System.out.println("*** Max sum: " + new MaxSumSolution().solution(A));
		
	}

}
