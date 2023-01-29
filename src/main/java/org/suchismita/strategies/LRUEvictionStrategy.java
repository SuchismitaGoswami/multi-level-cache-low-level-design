package org.suchismita.strategies;

import org.suchismita.algorithms.DoubleLinkedList;
import org.suchismita.algorithms.DoubleLinkedListNode;
import java.util.HashMap;

public class LRUEvictionStrategy<K> implements IEvictionStrategy<K>{
    HashMap<K, DoubleLinkedListNode<K>> pointerStore = new HashMap<K, DoubleLinkedListNode<K>>();
    DoubleLinkedList<K> doubleLinkedList = new DoubleLinkedList<K>();
    @Override
    public void keyAccessed(K key) {
        DoubleLinkedListNode<K> keyRef = pointerStore.get(key);
        if(keyRef != null){
            doubleLinkedList.remove(keyRef);
        }
        DoubleLinkedListNode<K> node = doubleLinkedList.add(key);
        pointerStore.put(key, node);
    }

    @Override
    public void evictKey() {
        K key = doubleLinkedList.removeLast();
        pointerStore.put(key, null);
    }
}
