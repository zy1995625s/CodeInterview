package Code14_ReverseList;

import Code12_RemoveLastKthNode.DoubleNode;
import Code12_RemoveLastKthNode.Node;

public class ReverseList {
	public static Node reverseList(Node cur) {
		Node pre = null;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public static DoubleNode reverseList(DoubleNode cur) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while(cur!=null) {
			next = cur.next;
			cur.next = pre;
			cur.last = next;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		
		head = reverseList(head);
		System.out.println("反转链表算法测试：");
		while(head != null) {
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println();
		DoubleNode dhead = new DoubleNode(0);
		dhead.next = new DoubleNode(1);
		dhead.next.next = new DoubleNode(2);
		dhead.next.next.next = new DoubleNode(3);
		dhead.next.next.next.next = new DoubleNode(4);
		dhead.next.next.next.next.next = new DoubleNode(5);
		dhead.next.last = dhead;
		dhead.next.next.last = dhead.next;
		dhead.next.next.next.last = dhead.next.next;
		dhead.next.next.next.next.last = dhead.next.next.next;
		dhead.next.next.next.next.next.last = dhead.next.next.next.next;
		
		dhead = reverseList(dhead);
		System.out.println("双向链表算法测试：");
		while(dhead != null) {
			System.out.print(dhead.value + "->");
			dhead = dhead.next;
		}
	}
}
