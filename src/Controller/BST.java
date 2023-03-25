package Controller;

import Controller.Node;

import java.util.function.Consumer;

public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public void insert(E value) {
        root = insert(root, value);
    }

    private Node<E> insert(Node<E> node, E value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value.compareTo(node.getData()) < 0) {
            node.setLeftChild(insert(node.getLeftChild(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRightChild(insert(node.getRightChild(), value));
        }

        return node;
    }

    public void inOrderTraversal(Consumer<E> consumer) {
        inOrderTraversal(root, consumer);
    }

    private void inOrderTraversal(Node<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.getLeftChild(), consumer);
        consumer.accept(node.getData());
        inOrderTraversal(node.getRightChild(), consumer);
    }

    public E search(E value) {
        return search(root, value);
    }

    private E search(Node<E> node, E value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.getData()) == 0) {
            return node.getData();
        } else if (value.compareTo(node.getData()) < 0) {
            return search(node.getLeftChild(), value);
        } else {
            return search(node.getRightChild(), value);
        }
    }
}