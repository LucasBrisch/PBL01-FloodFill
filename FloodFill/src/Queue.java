
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

    public boolean isEmpty() {return this.size == 0;}


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
