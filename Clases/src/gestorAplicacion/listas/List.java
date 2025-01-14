package listas;

public class List {
    private Node head;
    private Node tail;
    private int size;

    public List(){
        head = null;
        tail= null;
        size =0;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size ==0;
    }
    public Node First(){
        return head;
    }
    public Node Last(){
        return tail;
    }
    public void addFirst(Object a){
        Node temp = new Node(a);
        if(isEmpty()){
            head = temp;
            tail = temp;
        }
        else {
            temp.setNext(head);
            head =temp;
        }
        size++;
    }
    public void addLast(Object a){
        Node temp = new Node(a);
        if(isEmpty()){
            head = temp;
            tail = temp;
        }
        else {
            tail.setNext(temp);
            tail= temp;
        }
        size++;
    }
    public Object removeFirst(){
        if(!isEmpty()){
            Node temp = head;
            head = temp.getNext();
            temp.setNext(null);
            size--;
            return temp.getData();
        }
        else {
            return null;
        }
    }
    public Object removeLast(){
        if(size ==1){
            return removeFirst();
        }
        else{
            Node temp = tail;
            Node anterior = head;
            while(anterior.getNext()!= tail){
                anterior = anterior.getNext();
            }
            anterior.setNext(null);
            tail=  anterior;
            size --;
            return temp.getData();
        }
    }
    public Object remove(Object n) {
        if (isEmpty()) {
            return null;
        }

        // Removing the head
        if (n.equals(head.getData())) {
            return removeFirst();
        }

        // Removing the tail
        if (n.equals(tail.getData())) {
            return removeLast();
        }

        // Removing from the middle
        Node prev = head;
        Node actual = head.getNext();

        while (actual != null) {
            if (n.equals(actual.getData())) {
                prev.setNext(actual.getNext());
                if (actual == tail) {
                    tail = prev;
                }
                actual.setNext(null);
                size--;
                return actual.getData();
            }
            prev = actual;
            actual = actual.getNext();
        }

        return null;
    }
    public void print(){
        Node temp = head;
        while(temp!= null){
            System.out.println(temp.getData());
            temp = temp.getNext();

        }
    }

    // GETTERS AND SETTERS

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
