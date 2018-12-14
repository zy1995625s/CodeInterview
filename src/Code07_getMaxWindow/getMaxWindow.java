package Code07_getMaxWindow;

import java.util.LinkedList;
import java.util.Queue;

public class getMaxWindow {
	public static int[] getMaxWindowMethod(int[] arr, int w) {
		if(arr==null || w<1 || arr.length<w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<>();
		int[] res = new int[arr.length - w +1];
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()] < arr[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst() == i-w) {
				qmax.pollFirst();
			}
			if(i>=w-1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	public static int[] rightMethod(int[] arr, int w) {
		if (arr == null || w < 1 || arr.length < w) {
			return null;
		}
		int[] res = new int[arr.length - w + 1];
		for (int i = 0; i < arr.length - w + 1; i++) {
			int cur_max = Integer.MIN_VALUE;
			for (int j = i; j < i + w; j++) {
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
		for (int i : arr) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int testTime = 1000000;
		int size = 1000;
		int value = 1000;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(size, value);
			int[] arr2 = rightMethod(arr1, 10);
			int[] arr3 = getMaxWindowMethod(arr1, 10);
			System.out.println("Parsed Tests: " + i);
			if (!isEqual(arr2, arr3)) {
				succeed = false;
				System.out.print("right method: ");
				printArray(arr2);
				System.out.print("Test method: ");
				printArray(arr3);
				System.out.println("Origin Array: ");
				printArray(arr1);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucked!");
		return;
	}

}
