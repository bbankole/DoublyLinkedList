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


// DLL Feilds
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // Constructor
    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    // int size()
    public int size() {
        return size;
    }

    // boolean.isEmpty()
    public boolean isEmpty() {
        return size == 0;
    }

    // E first
    public E first() {
        if (isEmpty())
            return null;
        return head.getElement();
    }

    // E last
    public E last() {
        if (isEmpty())
            return null;
        return tail.getElement();
    }

    // void addFrist
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }

        size++;
    }

    // E removeLast
    public E removeLast() {
        if (isEmpty())
            return null;
        E removedElement = tail.getElement(); 

        if (head == tail) { 
            head = null;
            tail = null;
        } else { 
            Node<E> prevNode = tail.getPrev();
            prevNode.setNext(null);
            tail = prevNode;
        }

        size--;
        return removedElement;

    }

    // E removeFirst
    public E removeFirst() {
        if (isEmpty())
            return null; /

        E removedElement = head.getElement(); 

        if (head == tail) { 
            head = null;
            tail = null;
        } else { 
            Node<E> nextNode = head.getNext();
            nextNode.setPrev(null);
            head = nextNode;
        }

        size--;
        return removedElement;

    }


        public E get(int index) {
        if(index < 0 || index >= counter || isEmpty()){
            return null;
        }

        Node<E> curr = head;

        for(int i = 0; i < index; i++)
        {
            curr = curr.getNext();
        }

        return curr.getElement();

        }

    public E remove(int index) {
        if(index < 0 || index >= size || isEmpty())
        {
            return null;
        }


        if(index == 0) {
            return removeFirst();
        }

       if (index == counter - 1) {

        return removeLast();

       }

       Node<E> curr = head;

       for (int i = 0; i < index; i++)
       {
        curr = curr.getNext();
       }

       E removedElement = curr.getElement();

       Node<E> prevNode = curr.getPrev();
       Node<E> nextNode = curr.getNext();

       prevNode.setNext(nextNode);
       nextNode.setPrev(prevNode);

       counter--;

       return removedElement;

    }

    public void remove(Node<E> x) {

        if(x == null || isEmpty()) {
            return;
        }

        if (x == head) {
            removeFirst();
            return;
        }

        if(x == tail) {
            removeLast();
            return;
        }

        Node<E> prevNode = x.getPrev();
        Node<E> nextNode = x.getNext();


        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        counter--;

    }

    private Node<E> find(E element) {

        if(isEmpty()) {
            return null;
        }


        Node<E> current = head;

        while(current != null) {

            if((element == null && current.getElement() == null) ||
            (element != null && element.equals(current.getElement()))) {
                    return current;
                }

                current = current.getNext();
        }

        return null;

    }


    public void clear() {

        Node<E> current = head;

        while (current != null) {
            Node<E> next = current.getNext();

            current.setPrev(null);
            current.setNext(null);
            current.setElement(null);

            current = next;

        }

        head = null;
        tail = null;
        counter = 0;

        // when we remove all nodes, that's not just setting to null, but making them
        // eligible for Java garabage collection

    }


    public E set(int index, E element) {

        if(index < 0 || index >= counter || isEmpty()) {
            return null;
        }

        Node<E> current = head;

        for(int i = 0; i < index; i++)
        {
            current = current.getNext();
        }

        E oldElement = current.getElement();
        curent.setElement(element);

        return oldElement;

    }






}
