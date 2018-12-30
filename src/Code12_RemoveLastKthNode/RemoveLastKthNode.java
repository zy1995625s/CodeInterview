package Code12_RemoveLastKthNode;

public class RemoveLastKthNode {
	public static Node removeLastKthNode(Node head, int k) {
		if(head==null && k<1) {
			return head;
		}
		Node cur = head;
		while(cur != null) {
			k--;
			cur = cur.next;
		}
		if(k==0) {
			head = head.next;
		}
		if(k<0) {
			cur = head;
			while(++k != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}
	
	public static DoubleNode removeLastKthNode(DoubleNode head, int k) {
		if(head==null && k<1) {
			return head;
		}
		DoubleNode cur = head;
		while(cur != null) {
			k--;
			cur = cur.next;
		}
		if(k==0) {
			head = head.next;
			head.last = null;
		}
		if(k<0) {
			cur = head;
			while(++k != 0) {
				cur = cur.next;
			}
			DoubleNode newNext = cur.next.next;
			cur.next = newNext;
			if(newNext != null) {
				newNext.last = cur;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		Node head = new Node(0);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		
		head = removeLastKthNode(head, 1);
		System.out.println("单向链表算法测试：");
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
		
		dhead = removeLastKthNode(dhead, 6);
		System.out.println("双向链表算法测试：");
		while(dhead != null) {
			System.out.print(dhead.value + "->");
			dhead = dhead.next;
		}
		System.out.println();
	}
}
