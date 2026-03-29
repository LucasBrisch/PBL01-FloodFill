
public class Queue<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void enqueue(T e) {
        var newNode = new Node<>(e);

        if (isEmpty()) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.setNext(newNode);
            this.last = newNode;
        }
        this.size++;
    }
    public T dequeue() {
        if (isEmpty()) {return null;}


        var dataFromFirst = this.first.getData();

        this.first = this.first.getNext();
        this.size --;

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
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public Object[] toArray() {
        var array = new Object[this.size];
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
