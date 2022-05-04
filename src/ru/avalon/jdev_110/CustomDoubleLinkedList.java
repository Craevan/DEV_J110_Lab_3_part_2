package ru.avalon.jdev_110;

public class CustomDoubleLinkedList<T> {

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public CustomDoubleLinkedList() {
        this.size = 0;
    }

    //добавление значения в начало списка
    public void addToHead(T data) {
        if (this.size == 0)
            addFirstElement(data);
        else {
            Node<T> tmp = head;
            head = new Node<>(data);
            head.next = tmp;
            tmp.prev = head;
        }
        ++size;
    }

    //извлечение значения из начала списка без его удаления из списка
    public T getElementFromHead() {
        return head.element;
    }

    //извлечение значения из начала списка с удалением из списка;
    public T peekElementFromHead() {
        if (this.size != 0) {
            T element = head.element;
            head = head.next;
            head.prev = null;
            --size;
            return element;
        }
        return null;
    }

    //добавление значения в конец списка
    public void addToTail(T data) {
        if (this.size == 0)
            addFirstElement(data);
        else {
            Node<T> tmp = tail;
            tail = new Node<>(data);
            tail.prev = tmp;
            tmp.next = tail;
        }
        ++size;
    }

    //извлечение значения из конца списка без его удаления;
    public T getElementFromTail() {
        return tail.element;
    }

    //извлечение значения из конца списка с удалением
    public T peekElementFromTail() {
        if (size != 0) {
            T element = tail.element;
            tail = tail.prev;
            tail.next = null;
            --size;
            return element;
        }
        return null;
    }

    //определение, содержит ли список заданное значение, или нет
    public boolean contains(T data) {
        if (data == null)
            throw new IllegalArgumentException("аргумент не может быть null");
        if (size == 0)
            return false;
        else {
            Node<T> tmp = head;
            while (tmp != null) {
                if (data.equals(head.element)) {
                    return true;
                }
                tmp = tmp.next;
            }
        }
        return false;
    }

    //определение, является ли список пустым, или нет
    public boolean isEmpty() {
        return size == 0;
    }

    //печать всех значений списка
    public void printAll() {
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    //добавление всех значений заданного массива в начало списка
    public void addElementsFromArrayToHead(T[] datas) {
        if (datas == null)
            throw new IllegalArgumentException("аргумент не может быть null");

        for (T element : datas) {
            addToHead(element);
        }
    }

    //добавление всех значений заданной коллекции в начало списка
    public void addElementsFromCollectionToHead(Iterable<T> collection) {
        if (collection == null)
            throw new IllegalArgumentException("аргумент не может быть null");

        for (T element : collection) {
            addToHead(element);
        }
    }

    //обавление всех значений заданного массива в конец списка
    public void addElementsFromArrayToTail(T[] datas) {
        if (datas == null)
            throw new IllegalArgumentException("аргумент не может быть null");

        for (T element : datas) {
            addToTail(element);
        }
    }

    //обавление всех значений заданной коллекции в конец списка
    public void addElementsFromCollectionToTail(Iterable<T> collection) {
        if (collection == null)
            throw new IllegalArgumentException("аргумент не может быть null");

        for (T element : collection) {
            addToTail(element);
        }
    }

    //печать с хвоста
    public void printFromEnd() {
        Node<T> tmp = tail;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }

    //возвращает размер списка
    public int getSize() {
        return size;
    }

    private void addFirstElement(T data) {
        this.head = new Node<>(data);
        this.tail = head;
        this.head.next = null;
        this.head.prev = null;
    }

    private static class Node<T> {

        private final T element;
        private Node<T> next;
        private Node<T> prev;

        private Node(T element) {
            this.element = element;
        }
    }

}
