package Code00_Java_API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test_Colletions_Fill {
	public static void main(String[] args) {
		int[] arr = new int[10];
		Arrays.fill(arr, 5);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " | ");
		}
		System.out.println();
		
		List<Integer> intList = Arrays.asList(new Integer[10]);
		Collections.fill(intList, 10);
		intList.set(5, 11);
		for(int i=0; i<intList.size(); i++) {
			System.out.print(intList.get(i) + " | ");
		}
		System.out.println();
		System.out.println("===================");
		System.out.println("===================");
		System.out.println("===================");
//		System.out.println("===========================");
//		int[][] matrix = new int[10][10];
//		for(int i=0; i<10; i++) {
//			System.out.println("--------------------------------");
//			for(int j=0; j<10; j++) {
//				System.out.print(matrix[i][j] + " | ");
//			}	
//			System.out.println();
//		}
//		System.out.println("--------------------------------");
		
//		List<List<Integer>> mList = new ArrayList<>();
//		System.out.println(mList.size());
//		mList.add(new ArrayList<Integer>());
//		System.out.println(mList.size());
//		System.out.println(mList.get(0).size());
		
		int[] temp = new int[10];
		Arrays.fill(temp, 10);
		int[][] m = new int[10][];
		Arrays.fill(m, temp);
		for(int i=0; i<m.length; i++) {
			for(int j=0; j<m[0].length; j++) {
				System.out.print(m[i][j] + " | ");
			}
			System.out.println();
		}
		
		System.out.println("===================");
		System.out.println("===================");
		System.out.println("===================");
		
		List<Integer> templ = Arrays.asList(new Integer[10]);
		Collections.fill(templ, 10);
		System.out.println(templ.size());
		List<List<Integer>> ml = new ArrayList<>();
		Collections.fill(ml, templ);
		System.out.println(ml.size());
		for(int i=0; i<ml.size(); i++) {
			for(int j=0; j<ml.get(0).size(); j++) {
				System.out.print(ml.get(i).get(j) + " | ");
			}
			System.out.println();
		}
	}
}
