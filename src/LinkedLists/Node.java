package LinkedLists;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    void append(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void printList() {
        Node cur = this;

        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }

        System.out.println();
    }
}
