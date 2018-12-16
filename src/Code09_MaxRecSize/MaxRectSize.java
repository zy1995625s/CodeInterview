package Code09_MaxRecSize;

/**
 * 找左右两边第一个小的数，用栈底到栈顶递增的递增单调栈
 * 左边的第一个小的数，在目标元素入栈时确定
 * 右边的第一个小的数，在目标元素出栈时确定
 */
import java.util.Stack;

public class MaxRectSize {

	public static int getMaxRectSize(int[][] m) {
		if(m==null || m.length==0 || m[0].length==0) {
			return 0;
		}
		int[] h = new int[m[0].length];
		int maxArea = 0;
		for(int i=0; i!=m.length; i++) {
			for(int j=0; j!=m[0].length; j++) {
				h[j] = m[i][j] == 0 ? 0 : h[j]+1;
			}
			maxArea = Math.max(maxArea, getRectFromButtom(h));
		}
		return maxArea;
	}
	
	public static int getRectFromButtom(int[] h) {
		if(h==null || h.length==0) {
			return 0;
		}
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for(int i=0; i!=h.length; i++) {
			while(!s.isEmpty() && h[s.peek()] >= h[i]) {
				int j = s.pop();
				int k = s.isEmpty() ? -1 : s.peek();
				int curArea = (i-k-1) * h[j];
				maxArea = Math.max(maxArea, curArea);
			}
			s.push(i);
		}
		while(!s.isEmpty()) {
			int j = s.pop();
			int k = s.isEmpty() ? -1 : s.peek();
			int curArea = (h.length-k-1) * h[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		int[][] test = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 } };
		System.out.println(getMaxRectSize(test));
	}
}
