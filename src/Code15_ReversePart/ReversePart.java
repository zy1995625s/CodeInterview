package Code15_ReversePart;

public class ReversePart {
	public static Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node pre = head;
		Node fPre = null;
		Node tPos = null;
		while(pre != null) {
			len++;
			fPre = len == from - 1 ? pre : fPre;
			tPos = len == to + 1 ? pre : tPos;
			pre = pre.next;
		}
		
		if( from>to || from<1 || to>len) {
			return head;
		}
		
		pre = fPre == null ? head : fPre.next;
		Node cur = pre.next;
		pre.next = tPos;
		Node next = null;
		while(cur != tPos) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		if(fPre != null) {
			fPre.next = pre;
			return head;
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
		
		head = reversePart(head, 1, 5);
		System.out.println("反转链表部分算法测试：");
		while(head != null) {
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println();

	}
}
