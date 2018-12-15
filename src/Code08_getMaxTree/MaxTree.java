package Code08_getMaxTree;

import java.util.HashMap;
import java.util.Stack;

public class MaxTree {
	public static Node getMaxTree(int[] arr) {
		Node[] narr = new Node[arr.length];
		for(int i=0; i!=arr.length; i++) {
			narr[i] = new Node(arr[i]);
		}
		Stack<Node> s = new Stack<Node>();
		HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
		HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
		for(int i=0; i!=narr.length; i++) {
			while((!s.isEmpty()) && s.peek().value < narr[i].value) {
				popStackToMap(s, lBigMap);
			}
			s.push(narr[i]);
		}
		while(!s.isEmpty()) {
			popStackToMap(s, lBigMap);
		}
		for(int i=narr.length-1; i!=-1; i--	) {
			while((!s.isEmpty()) && s.peek().value < narr[i].value){
				popStackToMap(s, rBigMap);
			}
			s.push(narr[i]);
		}
		while(!s.isEmpty()) {
			popStackToMap(s, rBigMap);
		}
		Node head = null;
		for(int i=0; i!=narr.length; i++) {
			Node curNode = narr[i];
			Node left = lBigMap.get(curNode);
			Node right = rBigMap.get(curNode);
			if(left == null && right==null) {
				head = curNode;
			}else if(left == null) {
				if(right.left==null) {
					right.left = curNode;
				} else {
					right.right = curNode;
				}
			} else if(right ==null) {
				if(left.left == null) {
					left.left = curNode;
				} else {
					left.right= curNode;
				}
			} else {
				Node parent = left.value < right.value ? left : right;
				if(parent.left == null) {
					parent.left = curNode;
				} else if(parent.right == null) {
					parent.right = curNode;
				}
			}
		}
		
		return head;
	}
	
	public static void popStackToMap(Stack<Node> s, HashMap<Node, Node> m) {
		Node popNode = s.pop();
		if(s.isEmpty()) {
			m.put(popNode, null);
		} else {
			m.put(popNode, s.peek());
		}
	}
}
