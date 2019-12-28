package com.fruits.algo.list;

import java.util.Comparator;

public class ListUtil {
    public void insertAfterSpecificNode(ListNode node, Object obj) {
        ListNode newNode = new ListNode();
        newNode.data = obj;

        newNode.next = node.next;
        node.next = newNode;
    }

    public void insertNodeAsHead(ListNode head, Object obj) {
        ListNode newHead = new ListNode();
        newHead.data = obj;

        newHead.next = head;
        head = newHead;
    }

    public void insertNodeToEnd(ListNode head, Object obj) {
        ListNode newNode = new ListNode();

        if(head == null) {
            head = newNode;
            return;
        }

        ListNode n;
        for(n = head; n.next != null; n = n.next);

        n.next = newNode;
    }

    public void insertNodeIntoOrderedList(ListNode<Integer> head, Integer obj) {
        ListNode<Integer> newNode = new ListNode<Integer>();
        newNode.data = obj;

        if(head == null) {
            head = newNode;
            return;
        }

        ListNode<Integer> node, pre = null;
        for(node = head; node != null && obj > node.data; pre = node, node = node.next);

        if(node == head) {
            head = newNode;
        }else{
            pre.next = newNode;
        }

        newNode.next = node;
    }

    public void deleteNode(ListNode<Integer> head, Integer obj) {
        ListNode<Integer> node, pre = null;

        if(head == null) return;

        if(head.data == obj) {
            head = head.next;
            return;
        }

        for(node = head; node != null && node.data != obj; pre = node, node = node.next);

        if(node != null) {
            pre.next = node.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode pre = null, next;

        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }

        return pre;
    }
}
