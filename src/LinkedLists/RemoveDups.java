package LinkedLists;

import java.util.HashMap;

// Removes duplicates from a linked list

public class RemoveDups {
    public static void main(String[] args) {
        Node list = new Node(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(2);
        list.append(3);
        list.printList();

        removeDuplicatesConstantSpace(list).printList();

        Node list2 = new Node(1);
        list2.append(2);
        list2.append(2);
        list2.append(3);
        list2.append(4);
        list2.printList();

        removeDuplicatesConstantSpace(list2).printList();
    }

        public static Node removeDuplicates(Node head) {
        if (head == null) return null;

        HashMap<Integer, Boolean> map = new HashMap<>();
        Node cur = head;
        Node traveller;

        map.put(cur.data, true);

        while (cur != null && cur.next != null) {
            if (map.containsKey(cur.next.data)) {
                traveller = cur.next;

                while (traveller != null && map.containsKey(traveller.data)) {
                    traveller = traveller.next;
                }

                if (traveller != null) {
                    map.put(traveller.data, true);
                }

                cur.next = traveller;
            }
            else {
                map.put(cur.next.data, true);
            }

            cur = cur.next;
        }

        return head;
    }

    public static Node removeDuplicatesConstantSpace(Node head) {
        Node cur = head;
        Node runner;
        Node runnerPrev;

        // Todo process head

        while (cur != null) {
            runnerPrev = cur;
            runner = cur.next;

            while (runner != null) {
               if (runner.data != cur.data) {
                   runnerPrev = runner;
                   runner = runner.next;
               }
               else {
                    runnerPrev.next = runner.next;
                    break;
               }
            }

            cur = cur.next;
        }

        return head;
    }
}
