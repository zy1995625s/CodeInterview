package Code01_Stack_And_Queue;

import java.util.Stack;

public class getMinStack02 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public getMinStack02() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	public void push(int newNum) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}
		else if(newNum <= this.getMin()) {
			this.stackMin.push(newNum);
		}
		else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is Empty.");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is Empty.");
		}
		return this.stackMin.peek();
	}
}