package TreesAndGraphs;

import java.util.LinkedList;

public class Node<Any> {
    private Any val;

    public Node(Any val) {
        this.val = val;
    }

    LinkedList<Node<Any>> children = new LinkedList<>();

    public boolean equals(Node<Any> node) {
        if (this.val == node.val) return true;

        return false;
    }
}
