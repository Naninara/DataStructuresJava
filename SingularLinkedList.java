package LinkedListNew;

public class SingularLinkedList {
    public static void main(String[] args) {
        LinkedList li = new LinkedList();
        li.insertAtLast(5);
        li.insertAtLast(4);
        li.insertAtLast(2);
        li.insertAtLast(3);
        li.insertAtLast(8);
        li.insertAtLast(9);
        li.display();
        li.sort();
        li.display();

    }
}
