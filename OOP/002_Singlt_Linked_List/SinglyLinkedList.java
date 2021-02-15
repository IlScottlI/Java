public class SinglyLinkedList {
    private Node head = null;

    public SinglyLinkedList() {
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    private Node getLast() {
        Node runner = head;
        while (runner.next != null) {
            runner = runner.next;
        }
        return runner;
    }

    public Node find(int needle) {
        Node runner = head;
        while (runner.value != needle) {
            runner = runner.next;
        }
        return runner;
    }

    public void remove() {
        Node lastNode = this.getLast();
        Node runner = head;
        while (runner.next != lastNode) {
            runner = runner.next;
        }
        runner.setNext(null);
    }

    public void printValues() {
        System.out.println("*********** Values in List Order **********");
        Node runner = head;
        System.out.println("{ 'node' : " + head + ", 'value' : " + head.value + " }");
        while (runner.next != null) {
            runner = runner.next;
            System.out.println("{ 'node' : " + runner + ", 'value' : " + runner.value + " }");
        }
        System.out.println("*******************************************");
    }
}