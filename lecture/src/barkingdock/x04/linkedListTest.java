//package barkingdock.x04;
//
//
//public class linkedListTest {
//
//    public static void main(String[] args) {
//        test();
//    }
//
//    public static void test(){
//        LinkedList list = new LinkedList();
//        list.insert(0,3);
//        list.insert(1,4);
//        list.traverse();
//    }
//
//}
//class LinkedList{
//    public class Node{
//        Node prev;
//        Node next;
//        int data;
//        Node(int data){
//            this.data = data;
//            this.prev = null;
//            this.next = null;
//        }
//    }
//    private Node head;
//    private Node tail;
//    private int size;
//
//    public LinkedList(){
//        this.head = null;
//        this.tail = null;
//        this.size = 0;
//    }
//
//    public void traverse(){
//        if(head == null){
//            System.out.println("The list is empty");
//            return;
//        }
//        else{
//            Node cur = this.head;
//            while(cur != null){
//                System.out.print(cur.data +" ");
//                cur = cur.next;
//            }
//        }
//    }
//    public void insert(int idx, int num){
//        Node newNode = new Node(num);
//        if(idx < 0 || idx > size){
//            System.out.println("idx is not right number for the method insert");
//            return;
//        }
//        if(idx == 0){
//            if(head == null){
//                head = newNode;
//                tail = newNode;
//            }
//            else{
//                newNode.next = head;
//                head.prev = newNode;
//                head = newNode;
//            }
//        }
//        else if(idx == size){
//            if(head == null){
//                head = newNode;
//                tail = newNode;
//            }
//            else{
//                tail.next = newNode;
//                newNode.prev = tail;
//                tail = newNode;
//            }
//        }
//        else {
//            Node cur = this.head;
//            for(int i=0;i<size;i++){
//                if(i==idx-1){
//                    cur.next = newNode;
//                    newNode.prev = cur;
//                    newNode.next = cur.next;
//                    cur.next.prev = newNode;
//                    break;
//                }
//                else{
//                    cur = cur.next;
//                }
//            }
//        }
//
//        size++;
//    }
//    public Node get(int idx){
//        Node cur = this.head;
//        for(int i=0;i<idx;i++){
//            cur = cur.next;
//        }
//        return cur;
//    }
//
//    public void erase(int idx){
//        if(idx < 0 || size <= idx){
//            System.out.println("idx is wrong number for the method erase");
//            return;
//        }
//        Node nodeToRemove;
//        if(idx == 0) {
//            nodeToRemove = head;
//            head = head.next;
//            if (head != null) {
//                head.prev = null;
//            } else {
//                tail = null;
//            }
//        }
//        else if(idx == size - 1){
//            nodeToRemove = tail;
//            tail = tail.prev;
//            if(tail != null){
//                tail.next = null;
//            } else{
//                head = null;
//            }
//        }
//        else{
//            Node cur = get(idx);
//            nodeToRemove = cur;
//            cur.prev.next = cur.next;
//            cur.next.prev = cur.prev;
//        }
//        nodeToRemove.prev = null;
//        nodeToRemove.next = null;
//        size--;
//    }
//}
