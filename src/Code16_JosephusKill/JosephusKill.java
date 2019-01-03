package Code16_JosephusKill;

public class JosephusKill {
	public static Node josephusKill(Node head, int m) {
		if(head==null || head.next==head || m<1) {
			return head;
		}
		Node last = head;
		while(last.next != head) {
			last = last.next;
		}
		int count = 0;
		while(head != null) {
			if(++count == m) {
				last.next = head.next;
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}
}
