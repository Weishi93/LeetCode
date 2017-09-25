package leetcode;

public class P148 {
	private ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast != null || fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		P148 a = new P148();
		// TODO Auto-generated method stub
		ListNode h1 = new ListNode(1);
		ListNode h2 = new ListNode(2);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(4);
		ListNode h5 = new ListNode(5);
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		h5.next = null;
		ListNode mid = a.findMid(h1);
		System.out.println(mid.val);
	}

}
