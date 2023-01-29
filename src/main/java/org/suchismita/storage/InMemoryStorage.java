package org.suchismita.storage;

import org.suchismita.exceptions.StorageFullException;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class InMemoryStorage<K,V> implements IStorage<K,V>{

    private HashMap<K,V> storage;
    private int capacity;

    public InMemoryStorage(int capacity){
        this.capacity = capacity;
    }
    @Override
    public void add(K key, V value) throws StorageFullException {
        if(isStorageFull())
            throw new StorageFullException(capacity);
        storage.put(key, value);
    }

    @Override
    public V delete(K key) throws NoSuchElementException {
        V value = storage.get(key);
        if(value == null)
            throw new NoSuchElementException("No element exists with Key: " + key);
        storage.remove(key);
        return value;
    }

    @Override
    public V get(K key) {
        V value = storage.get(key);
        if(value == null)
            throw new NoSuchElementException("No element exists with Key: " + key);
        return value;
    }

    @Override
    public double getUsage() {
        return this.storage.size()/this.capacity;
    }

    private boolean isStorageFull(){
        return storage.size() == capacity;
    }
}
