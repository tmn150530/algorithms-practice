package LinkedLists;

import java.util.Stack;

public class IsPalindrome {
    public static void main(String[] args) {
        Node list = new Node(1);
        list.append(2);
        list.append(3);
        System.out.println(isPalindrome(list));
        //list.append(3);
        list.append(2);
        list.append(1);
        System.out.println(isPalindrome(list));
    }

    public static boolean isPalindrome(Node head) {
        Stack<Node> nodeStack = new Stack<>();

        Node cur = head;

        while (cur != null) {
            nodeStack.push(cur);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            int data = nodeStack.pop().data;
            if (data != cur.data) {
                return false;
            }
            cur = cur.next;
        }

        return true;
    }

}

