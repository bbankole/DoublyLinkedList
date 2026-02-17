class DLL<E> {

    class Node<E> {

    private E element;
    private Node<E> prev;
    private Node<E> next;
    

    public Node() {
        this.element = null;
        this.prev = null;   
        this.next = null;
    }

    public Node(E element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }


    public int size() {
        return this.counter;
    }

    public boolean isEmpty() {

    //counter cannot be null, since it's a primitive type

        if (this.counter == 0) {
            return true;
        } else {
            return false;
    } }

    public E first() {

        if (isEmpty()) {

            return null;
        }

        return head.getElement();

    }

    public E last() {

        if (isEmpty()) {
            return null;
        }

        return tail.getElement();

    }

    public void addFirst(Node head, E newData) {


        Node<E> newNode = new Node<>(element, null, head);

        if(isEmpty()) {

            head = newNode;
            tail = newNode; 
        }   // if the list is empty, this new list is the start and the end

        else {
            head.setPrev(newNode);

            head = newNode;
        }

        counter++;
        
    }





}
