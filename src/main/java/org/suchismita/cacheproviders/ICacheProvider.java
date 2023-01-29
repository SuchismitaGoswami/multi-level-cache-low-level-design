package org.suchismita.cacheproviders;

import java.util.NoSuchElementException;

public interface ICacheProvider<K ,V> {
     V get(K key) throws NoSuchElementException;
     void set(K key,V value);
     double getCurrentUsage();

}
