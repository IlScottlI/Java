public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    // Getters
    public int getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }

    // Setters
    public void setNext(Node next) {
        this.next = next;
    }

}
