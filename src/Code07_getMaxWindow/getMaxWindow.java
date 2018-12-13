package Code07_getMaxWindow;

import java.util.LinkedList;
import java.util.Queue;

public class getMaxWindow {
	public static int[] getMaxWindowMethod(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int index = 0;
		int[] res = new int[arr.length - w + 1];
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w) {
				qmax.peekFirst();
			}
			if (i > w) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	
	public static int[] rightMethod(int[] arr, int w) {
		if(arr==null || w<1 || arr.length<w) {
			return null;
		}
		int[] res = new int[arr.length-w+1];
		for(int i=0; i<arr.length-w+1; i++) {
			int cur_max = Integer.MIN_VALUE;
			for(int j=i; j<i+w; j++) {
				cur_max = Math.max(arr[j], cur_max);
			}
			res[i] = cur_max;
		}
		return res;
	}

	public static int[] generateRandomArray(int size, int value) {
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
		}
		return arr;
	}

	private static int[] copyArray(int[] arr) {
		// TODO Auto-generated method stub
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static void printArray(int[] arr) {
		for(int i:arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int testTime = 5000000;
		int size = 10;
		int value = 100;
		boolean succeed = true;
		for(int i=0; i<testTime; i++) {
			int[] arr1 = generateRandomArray(size, value);
			int[] arr2 = copyArray(arr1);
			int[] arr3 = copyArray(arr2);
			if(!isEqual(rightMethod(arr1, 3), getMaxWindowMethod(arr2, 3))) {
				succeed = false;
				printArray(arr3);
				break;
			}
		}
		System.out.println(succeed? "Nice!" :"Fucked!");
		return;
	}

}
