package listas;

public class DoubleNode {
    private Object data;
    private DoubleNode next;
    private DoubleNode prev;

    public DoubleNode(){
        data = null;
        next = null;
        prev = null;
    }
    public DoubleNode(Object data){
        this.data = data;
        next=null;
        prev= null;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
