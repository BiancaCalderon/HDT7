package Controller;

public class Node<E extends Comparable<E>> {
    private E data;
    private Node<E> leftChild;
    private Node<E> rightChild;

    public Node(E data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<E> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<E> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<E> rightChild) {
        this.rightChild = rightChild;
    }
}