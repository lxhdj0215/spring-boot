package com.lxhdj.algorithm;

/**
 * @description: 链表
 * @author: wangguijun1
 * @create: 2020-01-13 09:42
 **/

public class ListNode {
    private Object object;
    private ListNode next;

    public ListNode(Object object) {
        this.object = object;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        initNode(head, 10);
        printNode(head);
        ListNode reverseNode = reverseListNode(head);
        printNode(reverseNode);
    }

    public static ListNode reverseListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        ListNode nextNode = null;
        ListNode preNode = null;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public static void initNode(ListNode head, int nodeCount) {
        if (head == null) {
            return;
        }
        ListNode curNode = head;
        int count = 1;
        while (true) {
            if (count >= nodeCount) {
                break;
            }
            ListNode nextNode = new ListNode(count);
            curNode.setNext(nextNode);
            curNode = nextNode;
            count++;
        }

    }

    public static void printNode(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode curNode = head;
        while (curNode != null) {
            Object object = curNode.getObject();
            System.out.print(object + " ");
            curNode = curNode.getNext();
        }
        System.out.println();
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
