package org.suchismita.storage;

import org.suchismita.exceptions.StorageFullException;

import java.util.NoSuchElementException;

public interface IStorage<K,V> {
    void add(K key,V value) throws StorageFullException;
    V delete(K key) throws NoSuchElementException;
    V get(K key);
    double getUsage();

}
