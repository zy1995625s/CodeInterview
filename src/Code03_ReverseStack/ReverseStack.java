package Code03_ReverseStack;

import java.util.Stack;

public class ReverseStack {
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.isEmpty()) {
			return result;
		}
		else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	public static void reverseStack(Stack<Integer> stack) {
		if(stack.isEmpty()) {
			return;
		}
		int last = getAndRemoveLastElement(stack);
		reverseStack(stack);
		stack.push(last);
	}
}
