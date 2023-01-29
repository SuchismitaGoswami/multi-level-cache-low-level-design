package org.suchismita.algorithms;

import org.suchismita.models.Node;

public class DoubleLinkedListNode<T> extends Node<T> {
    private DoubleLinkedListNode<T> prev;
    DoubleLinkedListNode(T data){
        super(data);
        this.prev = null;
    }
    public DoubleLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoubleLinkedListNode<T> prev) {
        this.prev = prev;
    }
}
