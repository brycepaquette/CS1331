public class GenericLinkedList<E> {

    private class Node<E> { //inner class
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head; // the only instance variable of the list
    private Node<E> tail;
    
    public GenericLinkedList() {   
        head = null; // the list starts off empty
        tail = null;
    }

    public boolean isEmpty() {
        return (head == null); // the list is empty if head is null
    }

    public void addToFront(E newData) {
        Node <E> node = new Node<>(newData, head);
        
        if(isEmpty()) {
            tail = node;
        }
        head = node;
    }

    public void addToRear(E newData) {
        Node<E> node = new Node<E>(newData, null);
        Node<E> current = head;

        if(isEmpty()) {
            head = node;
        } 
        else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        tail = node;
    }

    public Node<E> removeFromFront() {
        Node <E> node = head;
        head = head.next;
        return node;
    }

    public Node<E> removeFromRear() {
        Node<E> current = head;
        Node<E> result = null;
        if (!isEmpty() && head != tail) {
            while(current.next != tail) {
                current = current.next;
            }
            tail = current;
            result = current.next;
        }
        else {
            result = tail;
            head = null;
            tail = null;
        }
        return result;
    }

    public String toString() {
        Node<E> current = head;
        String result = "";

        while(current != null) {
            result += current.data.toString() + "\n";
            current = current.next;
        }
        return result;
    }

    public boolean contains(E target) {
        Node<E> current = head;
        Boolean found = false;

        while(current.next != null && !found) {
            if(target.equals(current.data)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        GenericLinkedList<String> favBabySongs = new GenericLinkedList<>();
        favBabySongs.addToFront("Humpty Dumpty");
        favBabySongs.addToRear("Swing Low Sweet Chariot");
        favBabySongs.addToFront("Itsy Bitsy Spider");
        favBabySongs.addToRear("Twinkle, Twinkle Little Star");
        favBabySongs.addToFront("Wheels on the Bus");
        System.out.println(favBabySongs.toString());
        System.out.println(favBabySongs.contains("Humpty Dumpty"));
        System.out.println(favBabySongs.contains("Baby Shark"));
        assert favBabySongs.tail.next == null;
        System.out.println("Removed: " + ((favBabySongs.removeFromFront()).data).toString());
        System.out.println("Removed: " + ((favBabySongs.removeFromRear()).data).toString());
        System.out.println(favBabySongs.tail.data.toString());
        System.out.println("Removed: " + ((favBabySongs.removeFromRear()).data).toString());
        System.out.println(favBabySongs.tail.data.toString());
        System.out.println("Removed: " + ((favBabySongs.removeFromRear()).data).toString());
        System.out.println(favBabySongs.tail.data.toString());
        System.out.println("Removed: " + ((favBabySongs.removeFromRear()).data).toString());
        System.out.println(favBabySongs.tail);
    }
}