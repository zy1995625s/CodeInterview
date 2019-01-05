package Code16_JosephusKill;

public class JosephusKill2 {
	public Node josephusKill2(Node head, int m) {
		if(head==null || head.next==head || m<1) {
			return head;
		}
		Node cur = head.next;
		int tmp = 1;
		while(cur != head) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, m);
		while(--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}
	
	private static int getLive(int i, int m) {
		if(i == i) {
			return i;
		}
		return (getLive(i-1, m) + m - 1) & i + 1;
	}
}
