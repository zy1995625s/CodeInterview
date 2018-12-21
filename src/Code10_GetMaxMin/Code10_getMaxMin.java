package Code10_GetMaxMin;

/**
 * 题目
 * 	求最大值减去最小值小于等于num的子数组的数量
	给定数组arr与整数num，共返回有多少个子数组满足如下情况：
	max（arr[i...j]）-min（arr[i...j]） <= num

解法
	一种暴力解，时间复杂度为O（N^3）
	利用双端队列，可参考：生成窗口最大值数组
	
	构造两个双端队列：qmin与qmax。当子数组为arr[i...j]时，
	qmin维护arr[i...j]窗口子数组的最小值，qmax维护arr[i...j]窗口子数组的最大值。
	那么子数组向右扩一个位置变成arr[i...j+1]时，或
	qmin维护arr[i...j]窗口子数组的最小值时，
	qmax与qmin能在O（1）时间内更新，
	在O（1）时间内得到a[i...j+1]的最大值与最小值。
	
	此外，如果子数组arr[i...j]满足条件，那么其中每一个子数组都满足条件，
	如果arr[i...j]不满足条件，那么其中每一个子数组都不满足条件。
 */

import java.util.LinkedList;

public class Code10_getMaxMin {
	public static int getNum(int[] arr, int num) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<>();
		LinkedList<Integer> qmax = new LinkedList<>();
		int i=0;
		int j=0;
		int res=0;
		while(i<arr.length) {
			while(j<arr.length) {
				while(!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if(arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num) {
					break;
				}
				j++;
			}
			if(qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			if(qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			res += j-i;
			i++;
		}
		return res;
	}
	
	public static int rightMethod(int[] arr, int num) {
		if(arr==null || arr.length==0) {
			return 0;
		}
		int i=0;
		int res=0;
		while(i<arr.length) {
			int curMax = Integer.MIN_VALUE;
			int curMin = Integer.MAX_VALUE;
			int j=i;
			while(j<arr.length) {
				for(int k=i; k<j+1; k++) {
					curMax = Math.max(curMax, arr[k]);
					curMin = Math.min(curMin, arr[k]);
				}
				if(curMax - curMin <= num) {
					res++;
				}
				j++;
			}
			i++;
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
		int testTime = 10000;
		int size = 100;
		int value = 1000;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(size, value);
			int res2 = rightMethod(arr1, 3);
			int res3 = getNum(arr1, 3);
			System.out.println("Parsed Tests: " + i);
			if (res2 != res3) {
				succeed = false;
				System.out.print("right method: ");
				System.out.println(res2);
				System.out.print("Test method: ");
				System.out.println(res3);
				System.out.println("Origin Array: ");
				printArray(arr1);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucked!");
		return;
	}
}
