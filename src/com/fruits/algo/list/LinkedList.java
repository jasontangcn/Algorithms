package com.fairchild.algo.list;

public class LinkedList {
	public static ListNode reverse(ListNode head) {
		ListNode p, p1 = null, p2 = head;
		while (null != p2) {
			p = p2;
			p2 = p2.next;
			p2.next = p1;
			p1 = p;
		}
		return p1;
	}
}
