package Code01_Stack_And_Queue;

import java.util.Stack;

public class getMinStack{
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public getMinStack() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	public void push(int newNum) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}
		if(newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		int value = stackData.pop();
		if(value == this.getMin()) {
			this.stackMin.pop();
		}
		return value;
	}
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return this.stackMin.peek();
	}
}
