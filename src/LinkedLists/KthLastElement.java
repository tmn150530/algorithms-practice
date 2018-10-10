package LinkedLists;

public class KthLastElement {

    public static void main(String[] args) {
        Node list = new Node(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.append(7);
        list.printList();

        System.out.println(findKthLastElement(list, 3).data);
    }

    public static Node findKthLastElement(Node head, int k) {
        Node cur = head;

        for (int i = 0; i < k; i++) {
            if (cur == null) {
                return null;
            }

            cur = cur.next;
        }

        Node trailer = head;

        while (cur != null) {
            cur = cur.next;
            trailer = trailer.next;
        }

        return trailer;
    }
}
