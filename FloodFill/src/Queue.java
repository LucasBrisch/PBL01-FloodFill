
public class Queue<T> {
    private Node<T> first;
    // documentating calls this top, but it feels wrong
    private Node<T> last;
    private int size;

    public Queue() {
        // don't need to write the null fields, but it's good practice
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void enqueue(T e) {
        var newNode = new Node<>(e);

        if (isEmpty()) {
            // if the queue is empty the new item is both the first and last
            this.first = newNode;
            this.last = newNode;
        } else {
            // the current item will point to the new item behind it
            this.last.setNext(newNode);
            // add the new item to the last position
            this.last = newNode;
        }
        this.size++;
    }
    public T dequeue() {
        if (isEmpty()) {return null;}


        var dataFromFirst = this.first.getData();

        // moves the second item to the first position
        this.first = this.first.getNext();
        this.size --;

        // if the queue becomes empty the last node should also be empty
        if (isEmpty()) {this.last = null;}

        return dataFromFirst;
    }

    public T front() {
        if (isEmpty()) {return null;}
        else {return this.first.getData();}
    }

    public boolean isEmpty() {return this.size == 0;}

    public int size() {return this.size;}

    public void clear() {
        // we can just delete the first and last nodes + zero the size and the garbage collector will clean up the rest
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    // Apparently the Java compiler actually deletes the generic? So we gotta use Object[]
    public Object[] toArray() {
        var array = new Object[this.size];
        // we gotta have a node to iterate over the linked list
        Node<T> current = this.first;

        for (int index = 0; current != null; index++) {
            array[index] = current.getData();
            current = current.getNext();
        }

        return array;
    }

    public String toString() {

        if (isEmpty()) {return "[]";}

        String result = "[";

        for (Node<T> current = this.first; current != null; current = current.getNext()) {

            result += current.getData();

            if (current.getNext() != null) {
                result += ", ";
            }
        }

        return result + "]";
    }
}
