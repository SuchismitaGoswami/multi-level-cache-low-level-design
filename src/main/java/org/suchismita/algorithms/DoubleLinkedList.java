package org.suchismita.algorithms;
import org.suchismita.exceptions.EmptyLinkedListException;

public class DoubleLinkedList<T> {
    DoubleLinkedListNode<T> head;
    DoubleLinkedListNode<T> tail;

    public DoubleLinkedListNode<T> add(T key) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>(key);
        if(this.head == null)
            this.tail = this.head = newNode;
        else{
            newNode.setNext(this.head);
            this.head.setPrev(newNode);
            this.head = newNode;
        }
        return newNode;
    }

    public void remove(DoubleLinkedListNode<T> keyRef) {
        if(keyRef == this.head){
            this.head = (DoubleLinkedListNode<T>) this.head.getNext();
        }else if(keyRef == this.tail){
            this.tail = this.tail.getPrev();
        }
        keyRef.getPrev().setNext(keyRef.getNext());
        ((DoubleLinkedListNode<T>) keyRef.getNext()).setPrev(keyRef.getPrev());
    }

    public T removeLast() {
        if(this.tail == null){
            throw new EmptyLinkedListException("LinkedList is empty!");
        }else{
            T data = this.tail.getData();
            if(this.tail == this.head){
                this.tail = this.head = null;
            }else {
                this.tail = this.tail.getPrev();
                ((DoubleLinkedListNode<T>) this.tail.getNext()).setPrev(null);
                this.tail.setNext(null);
            }
            return data;
        }
    }
}
