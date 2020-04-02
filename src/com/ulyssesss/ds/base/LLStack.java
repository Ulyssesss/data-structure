package com.ulyssesss.ds.base;

/**
 * 栈 - 链表实现 Linked List Stack
 *
 * @author jiangyue
 */
public class LLStack {

    private ListNode listNode;

    public boolean isEmpty() {
        return listNode == null;
    }

    public void push(int data) {
        ListNode newNode = new ListNode(data);
        newNode.setNext(listNode);
        listNode = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return 0;
        } else {
            int top = listNode.getData();
            listNode = listNode.getNext();
            return top;
        }
    }

    public int top() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return 0;
        } else {
            return listNode.getData();
        }
    }

    public void clearStack() {
        listNode = null;
    }
}
