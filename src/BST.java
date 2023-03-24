public class BST<E extends Comparable<E>> {
    private Node<E> root;

    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(E data) {
        root = insertHelper(root, data);
    }

    private Node<E> insertHelper(Node<E> node, E data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertHelper(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertHelper(node.right, data);
        }

        return node;
    }

    public boolean search(E data) {
        return searchHelper(root, data);
    }

    private boolean searchHelper(Node<E> node, E data) {
        if (node == null) {
            return false;
        }

        if (node.data.equals(data)) {
            return true;
        } else if (data.compareTo(node.data) < 0) {
            return searchHelper(node.left, data);
        } else {
            return searchHelper(node.right, data);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversalHelper(root);
    }

    private void inOrderTraversalHelper(Node<E> node) {
        if (node != null) {
            inOrderTraversalHelper(node.left);
            System.out.println(node.data);
            inOrderTraversalHelper(node.right);
        }
    }
}
