package demo;

/**
 * Created by leicheng on 17-1-4.
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode leftHead = null;
		ListNode rightHead = null;
		ListNode leftEnd = null;
		ListNode rightEnd = null;
		ListNode pointer = head;
		while (pointer != null) {

			if (pointer.val < x) {

				if (leftHead == null) {
					leftHead = pointer;
					leftEnd = pointer;
//					pointer = pointer.next;

				} else {
					leftEnd.next = pointer;
//					pointer = pointer.next;
					leftEnd = pointer;
				}

			} else {
				if (rightHead == null) {
					rightHead = pointer;
					rightEnd = pointer;
//					pointer = pointer.next;
				} else {
					rightEnd.next = pointer;
//					pointer = pointer.next;
					rightEnd = pointer;
				}
			}
			pointer = pointer.next;
		}
		if (rightEnd != null) {
			rightEnd.next = null;
		}
		if (leftEnd != null) {
			leftEnd.next = rightHead;
		}
		return leftHead == null ? rightHead : leftHead;
	}

	public static void main(String[] args) {
//		143252
//		ListNode head = new ListNode(1,
//				new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
		ListNode head = new ListNode(2, new ListNode(1));

		PartitionList partitionList = new PartitionList();
		ListNode partition = partitionList.partition(head, 2);
		while (partition != null) {
			System.out.println(partition.val);
			partition = partition.next;
		}

	}


}



class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
