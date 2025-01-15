package gestorAplicacion.listas;

public class DoubleList {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;
    public DoubleList(){
        head = null;
        tail = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public DoubleNode first(){
        return head;
    }
    public DoubleNode last(){
        return tail;
    }
    public void addFirst(Object a){
        DoubleNode temp = new DoubleNode(a);
        if (isEmpty()){
            head = temp;
            tail = temp;
        }
        else {
            temp.setNext(head);
            head.setPrev(temp);
            head= temp;
        }
        size++;
    }
    public void addLast(Object a){
        DoubleNode temp = new DoubleNode(a);
        if(isEmpty()){
            head = temp;
            tail = temp;
        }
        else{
            tail.setNext(temp);
            temp.setPrev(tail);
            tail = temp;
        }
        size++;
    }
    public Object removeFirst(){
        if(isEmpty()){
            return null;
        }
        else{
            DoubleNode temp = head;
            head =temp.getNext();
            temp.setNext(null);
            temp.setPrev(null);
            size--;
            return temp.getData();
        }
    }
    public Object removeLast(){
        if(isEmpty()){
            return null;
        }
        else{
            DoubleNode temp= tail;
            tail = temp.getPrev();
            tail.setNext(null);
            temp.setPrev(null);
            size--;
            return temp.getData();
        }
    }
    public Object remove(DoubleNode n){
        if (n== head){
            return removeFirst();
        } else if (n== tail) {
            return removeLast();
        }
        else{
            Object e = n.getData();
            DoubleNode p = n.getPrev();
            DoubleNode nx = n.getNext();
            p.setNext(nx);
            nx.setPrev(p);
            n.setNext(null);
            n.setPrev(null);
            size--;
            return e;
        }
    }
    public void addBefore(DoubleNode n, Object e){
        if(n==head){
            addFirst(e);
        } else {
            DoubleNode m = new DoubleNode(e);
            DoubleNode p = n.getPrev();
            p.setNext(m);
            m.setPrev(p);
            m.setNext(n);
            n.setPrev(m);
            size++;

        }
    }
    public void addAfter(DoubleNode n,Object e){
        if(n==tail){
            addLast(e);
        } else {
            DoubleNode m = new DoubleNode(e);
            DoubleNode nx = n.getPrev();
            n.setNext(m);
            m.setPrev(n);
            m.setNext(nx);
            nx.setPrev(m);
            size++;

        }
    }
    public void print(){
        DoubleNode temp = head;
        while(temp!= null){
            System.out.println(temp.getData());
            temp = temp.getNext();

        }
    }

    public DoubleNode getHead() {
        return head;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
