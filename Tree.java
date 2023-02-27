package Trees;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        this.left =null;
        this.right =null;
    }
}
class Main{
    public static void main(String[] args) {
        Node root = new Node(20);
        Node first = new Node(30);
        root.left = first;
        Node firstRight = new Node(80);
        first.right = firstRight;
        Node second = new Node(40);
        root.right = second;
        Node n = new Node(70);
        second.left = n;
        Node third = new Node(50);
        first.left = third;
        Node fourth= new Node(60);
        second.right = fourth;
        //inOrder(root);
        //preOrder(root);
        //postOrder(root);
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
       levelOrder(root,li,0);
        System.out.println(li);
        for (int i = 0; i < li.size(); i++) {
            if((i&1)==1){
                Collections.reverse(li.get(i));
            }
        }
    }
    public static void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static void preOrder(Node root){
        if(root==null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }
    public static void levelOrder(Node root, ArrayList<ArrayList<Integer>> li,int l){
        if(root==null) return;
        if(l==li.size()){
            ArrayList<Integer> m = new ArrayList<>();
            m.add(root.data);
            li.add(m);
        }
        else{
            li.get(l).add(root.data);
        }
        levelOrder(root.left, li, l+1);
        levelOrder(root.right, li, l+1);
    }
    public static int height(Node root){
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        return (int) Math.max(left,right)+1;
    }
    public boolean isBalanced(Node root){
        if(root==null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1) return false;
        boolean x = isBalanced(root.left);
        boolean y = isBalanced(root.right);
        if(x&y) return true;
        return false;
    }
}
