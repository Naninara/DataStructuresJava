package LinkedListNew;

public class DoubleLinkedList {

    NodeD head;
    public void insetFirst(int val){
        NodeD node= new NodeD();
        node.val = val;
        node.next = head;
        node.prev = null;
        if(head!=null){
            head.prev =  node;
        }
        head = node;
    }
    public void display(){
        NodeD node = head;
        NodeD last = null;
        while(node!=null){
            System.out.print(node.val+"--->");
            last = node;
            node = node.next;

        }
        System.out.print("End");
        while (last!=null){
            System.out.print(last.val+"-->");
            last = last.prev;
        }
        System.out.println("End");
    }
}
class NodeD{
    int val;
    NodeD next;
    NodeD prev;

}
