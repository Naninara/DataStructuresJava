package LinkedListNew;

public class LinkedList {
    Node head;
    Node tail;
    int size;
    LinkedList(){
        this.size=0;
    }
    public  void insertAtStart(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail==null){
            tail = head;
        }
        size++;
    }
    public void insertAtLast(int val){
        if(tail==null){
            insertAtStart(val);
            return;
        }
        Node temp = new Node(val);
        tail.next = temp;
         tail = temp;
         size++;

    }
    public void insert(int val,int index){
        if(index==0){
            insertAtStart(val);
            return;
        }
        if(index==size){
            insertAtLast(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i <index ; i++) {
            temp = temp.next;
        }
        Node node = new Node(val,temp.next);
        temp.next = node;
        size++;

    }
    public int deleteFirst(){
        int data = head.val;
        head = head.next;
        if(head==null){
            tail =null;
        }
        size--;
        return data;
    }
    public int deleteLast(){
        if(size<=1){
           return deleteFirst();

        }
        Node temp = reference(size-2);
        int val = tail.val;
        tail = temp;
        tail.next = null;
        size--;
        return val;

    }
    public int delete(int index){
        if(index==0) return deleteFirst();
        if (index==size-1) return deleteLast();
        Node previous = reference(index-1);
        previous.next = previous.next.next;
        return previous.next.val;
    }

    public Node reference(int index){
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val+"--> ");
            temp = temp.next;
        }
        System.out.print("End");
    }
    public Node findNode(int value){
        Node node = head;
        while (node!=null){
            if(node.val==value){
                return node;
            }
            node = node.next;
        }
        return null;
    }
    public void deleteDuplictes(){
        Node node = head;
        while(node.next!=null){
            if(node.val==node.next.val){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }
        }
    }
    public LinkedList merge(LinkedList l1 , LinkedList l2){
        Node head1 = l1.head;
        Node head2 = l2.head;
        LinkedList ans = new LinkedList();
        while(head1!=null && head2!=null){
            if(head1.val<head2.val){
                ans.insertAtLast(head1.val);
                head1 = head1.next;
            }
            else{
                ans.insertAtLast(head2.val);
                head2 = head2.next;
            }
        }
        while (head1!=null){
            ans.insertAtLast(head1.val);
            head1 = head1.next;
        }
        while (head2!=null){
            ans.insertAtLast(head2.val);
            head2 = head2.next;
        }
        return ans;
    }
    public void sort(){
        Node temp1 = head;
        while(temp1.next!=null){
            Node temp2 = temp1.next;
            while (temp2.next!=null){
                if(temp2.val<temp1.val){
                    int nodeData = temp1.val;
                    temp1.val = temp2.val;
                    temp2.val = nodeData;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }
    public void detectLoop(){
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) System.out.println("Cycle is detected");
        }
        System.out.println("no cycle deteceted");
    }


}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
