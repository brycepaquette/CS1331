public class LinkedList<T> implements List<T> {
    
    Node<T> head;
    Node<T> tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        // setting size to 0 in the constructor was not explicitly mentioned as a step but they also mention to set this to 0 when the list is empty
        size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addAtIndex(T data, int index) {
        Node<T> pointer = head;
        Node<T> newNode;

        if(index < 0 || index > size) {
            throw new IllegalArgumentException("Your index is out of bounds");
        }
        else if(data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }
        else if(index == 0) {
            head = new Node<T>(data, head); // set new node as head and old head as next
            tail = head;
        }
        else if(index == size) {
            Node<T> node = new Node<T>(data, null);
            tail.setNext(node); 
            tail = node; // Update tail
        }
        else {
            // Traverse to index - 1
            for(int i=0; i < index - 1; i++) {
                pointer = pointer.getNext(); // pointer stops at index - 1
            }
            newNode = new Node<T>(data, pointer.getNext()); // Create new node and set next to node at index
            pointer.setNext(newNode); // set previous node.next to the new node          
        }
        size += 1; // Update size;
    }

    public T getAtIndex(int index) {
        Node<T> pointer = head; // initiate pointer to traverse the list
        
        if(isEmpty()) {
            return null;
        }
        else if(index < 0 || index > (size - 1)) {
            throw new IllegalArgumentException("Your index is out of bounds");
        }
        else {
            for(int i=0; i < index; i++) {
                pointer = pointer.getNext();
            }
        }
        return pointer.getData();
    }

    public T removeAtIndex(int index) {
        Node<T> pointer = head;
        Node<T> removedNode;

        if(isEmpty()){
            return null;
        }
        else if(index < 0 || index > (size - 1)) {
            throw new IllegalArgumentException("Your index is out of bounds");
        }
        else if(index == 0) {
            removedNode = pointer;
            head = pointer.getNext();
        }
        else {
            for(int i = 0; i < index - 1; i++) {
                pointer = pointer.getNext();
            }
            removedNode = pointer.getNext();
            pointer.setNext(removedNode.getNext());
            
            tail = removedNode == tail ? pointer : tail;
        }

        size -= 1;

        return removedNode.getData();

    }

    public T remove(T data) {
        T foundData = null;
        Node<T> pointer = head;
        Node<T> prevNode;

        if(isEmpty()) {
            return null;
        }
        else if (pointer.getData() == data && pointer == head) {
            foundData = pointer.getData();
            head = pointer.getNext();
        } 
        else {
            while (pointer != null) {
                prevNode = pointer;
                pointer = pointer.getNext();
                if (pointer.getData() == data) {
                    foundData = pointer.getData();
                    prevNode.setNext(pointer.getNext());
                    if(pointer == tail) {
                        tail = prevNode;
                    }
                }
            }
        }
        size -= 1;
        return foundData;


    }



    public static void main(String[] args) {

        // LinkedList<String> list = new LinkedList<>();
        // LinkedList<String> listCopy;
        // LinkedList<String> emptyList = new LinkedList<>();

        // // Test initialized list
        // assert list.getHead() == null;
        // assert list.getTail() == null;
        // assert list.size() == 0;
        // System.out.println("Initialized list passed (Head & Tail are null, size is 0)");

        // //Test addAtIndex()
        // try {
        //     list.addAtIndex(null, 0);
        // }
        // catch (Exception e) {
        //     assert e.toString().equals("You cannot add null data to the list");
        //     System.out.printf("PASSED - list.addAtIndex(null, index) throws %s", e.toString());
        // }
        // try {
        //     list.addAtIndex("hello", 100);
        // }
        // catch(Exception e) {
        //     assert e.toString().equals("Your index is out of bounds");
        //     System.out.printf("PASSED - addAtIndex('hello', 100) throws %s\n", e.toString());
        // }
        // list.addAtIndex("0", 0);
        // list.addAtIndex("2", 1);
        // list.addAtIndex("1", 1);

        // // Copy list
        // LinkedList<String> list2 = new LinkedList<String>(list);

        // // Test getAtIndex()
        // assert list.getAtIndex(0).equals("0");
        // assert list.getAtIndex(1).equals("1");
        // assert list.getAtIndex(2).equals("2");
        // System.out.println("PASSED - List is in order: [0,1,2]");
        // assert emptyList.getAtIndex(0) == null;
        // System.out.println("PASSED - getAtIndex() returns null for empty list");
        // try {
        //     list.getAtIndex(100);
        // }
        // catch(Exception e) {
        //     assert e.toString().equals("Your index is out of bounds");
        //     System.out.printf("PASSED - getAtIndex(100) throws %s\n", e.toString());
        // }

        // // Test removeAtIndex()
        // assert emptyList.removeAtIndex(0) == null;
        // System.out.println("PASSED - removeAtIndex() returns null for empty list");
        // assert list.removeAtIndex(0).equals("0") && list.getHead().getData().equals("1");
        // System.out.println("PASSED - removeAtIndex(head) returns expected output & sets new head correctly");

        // // Test clear()
        // list.clear();
        // assert list.getHead() == null && list.getTail() == null && list.size() == 0;
        // System.out.println("PASSED - clear() sets head & tail to null, size to 0");
    }
}
