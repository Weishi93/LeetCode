package leetcode;
public class p23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int emptyList = 0;
        while (emptyList < lists.length) {
            int minNode = 0;
            for (int i = 0; i < lists.length; i++) { // make min node refers to the first non-null node
                if (lists[i] != null) {
                    minNode = i;
                }
            }
            for (int i = 0; i < lists.length; i++) { // find the minimum listnode among all heads
                if (lists[i] == null) {
                    continue;
                } else if (lists[i].val < lists[minNode].val) {
                    minNode = i;
                }
            }
            if (lists[minNode] == null) {
                emptyList++;
                continue;
            }
            node.next = lists[minNode];
            node = node.next;
            lists[minNode] = lists[minNode].next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
    }
}

