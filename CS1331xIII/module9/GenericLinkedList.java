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
    
    public GenericLinkedList() {   
        head = null; // the list starts off empty
    }

    public boolean isEmpty() {
        return (head == null); // the list is empty if head is null
    }

    public void addToFront(E newData) {
        head = new Node<E>(newData, head);
    }

    public void addToRear(E newData) {
        Node<E> node = new Node<E>(newData, null);
        Node<E> current = head;

        if(isEmpty()) {
            head = node;
        } else {
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
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
    }
}