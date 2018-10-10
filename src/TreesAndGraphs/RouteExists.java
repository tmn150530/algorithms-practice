package TreesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;

public class RouteExists {

    public static void main(String[] args) {
        Node<Integer> node0 = new Node<>(0);
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node9 = new Node<>(9);

        node0.children.add(node1);
        node0.children.add(new Node<>(5));
        node0.children.add(new Node<>(6));
        node0.children.add(new Node<>(7));

        node1.children.add(new Node<>(4));
        node1.children.add(new Node<>(8));
        node1.children.add(node9);

        node2.children.add(new Node<>(12));
        node2.children.add(new Node<>(1));
        node2.children.add(new Node<>(3));

        System.out.println(isConnected(node0, node9));
    }


    static boolean isConnected(Node node1, Node node2) {
        HashSet<Node> visitedByNode1 = new HashSet<>();
        HashSet<Node> visitedByNode2 = new HashSet<>();

        LinkedList<Node> queue1 = new LinkedList<>();
        LinkedList<Node> queue2 = new LinkedList<>();

        queue1.add(node1);
        queue2.add(node2);

        boolean bothEmpty = false;

        while (!bothEmpty) {
            if (processNode(queue1, visitedByNode2, node2)) {
                 return true;
            }

            if (processNode(queue2, visitedByNode1, node1)) {
                return true;
            }

            if (queue1.isEmpty() && queue2.isEmpty()) bothEmpty = true;
        }

        return false;
    }

    static boolean processNode(LinkedList<Node> queue, HashSet<Node> visited, Node otherNode) {
        if (!queue.isEmpty()) {
            Node<?> curr = queue.pop();

            if (curr.equals(otherNode) || visited.contains(curr)) {
                return true;
            }

            visited.add(curr);

            for (Node child: curr.children) {
                queue.add(child);
            }
        }

        return false;
    }

}
