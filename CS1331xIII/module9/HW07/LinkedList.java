public class LinkedList<T> implements List<T> {
    
    Node<T> head;
    Node<T> tail;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(list.getHead());
        list.getTail();

    }


}
