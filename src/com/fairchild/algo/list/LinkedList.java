package com.fairchild.algo.list;

public class LinkedList {
	private static class ListNode {
		private Object data;
		private ListNode next;
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public ListNode getNext() {
			return next;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	
	public static ListNode reverse(ListNode head) {
		ListNode p, p1 = null, p2 = head;
		while(null != p2) {
			p = p2;
			p2 = p2.next;
			p2.next = p1;
			p1 = p;
		}
		return p1;
	}
}
