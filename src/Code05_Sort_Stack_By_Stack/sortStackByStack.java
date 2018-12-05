package Code05_Sort_Stack_By_Stack;

import java.util.Stack;

public class sortStackByStack {
	public static void sortStack(Stack<Integer> s) {
		Stack<Integer> h = new Stack<Integer>();
		while(!s.isEmpty()) {
			int cur = s.pop();
			while(!h.isEmpty() && h.peek()>cur) {
				s.push(h.pop());
			}
			h.push(cur);
		}
		while(!h.isEmpty()) {
			s.push(h.pop());
		}
	}
}
