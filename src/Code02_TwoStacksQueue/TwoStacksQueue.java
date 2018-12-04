package Code02_TwoStacksQueue;

import java.util.Stack;

public class TwoStacksQueue {
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	
	public TwoStacksQueue() {
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
	}
	
	public void add(int newNum) {
		stackPush.push(newNum);
	}
	public int poll() {
		if(stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new RuntimeException("Your Queue is Empty!");
		}
		else if(stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	public int peek() {
		if(stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new RuntimeException("Your Queue is Empty!");
		}
		else if(stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
}
