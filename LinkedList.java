/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mdhqureshi
 */
public class LinkedList<T> {

    private int size;
    public Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        size = 0;
        head = tail = null;
    }

    public class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
            Node<T> next = null;
            Node<T> prev = null;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public void append(T data) {
        Node<T> temp = new Node<T>(data);
        if (this.isEmpty()) {
            head = tail = temp;
            ++size;
        } else {
            temp.next = null;
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
            ++size;
        }
        System.out.println("Appended");
    }

    public void addHead(T data) {
        Node<T> temp = new Node<T>(data);
        if (this.isEmpty()) {
            head = tail = temp;
            ++size;
        } else {
            temp.prev = null;
            temp.next = head;
            head = temp;
            ++size;
        }
    }

    public void insertAfter(Node<T> ref, T data) {
        Node<T> temp = new Node<T>(data);
        if (ref == null) {
            throw new IllegalArgumentException("Null reference entered");
        } else {
            temp.next = ref.next;
            temp.prev = ref;
            ref.next = temp;
            temp.next.prev = temp;
            size++;
        }
    }

    public void deleteByData(T data) {
        if (isEmpty()) {
            throw new RuntimeException("Linked List is already empty");
        } else {
            Node<T> trav = head;
            while (trav != null) {
                if (trav.data == data) {

                    if (trav.prev == null) {
                        head = trav.next;
                        head.prev = null;
                    } else if (trav.next == null) {
                        tail = trav.prev;
                        tail.next = null;
                    } else {
                        trav.prev.next = trav.next;
                        trav.next.prev = trav.prev;
                    }
                    size--;
                    break;
                }
                trav = trav.next;
            }
        }
    }

    public void printList() {
        if (this.isEmpty()) {
            System.out.println("Empty list");
        } else {
            Node<T> trav = head;
            while (trav != null) {
                System.out.println(trav.data);
                trav = trav.next;
            }
        }
    }

}