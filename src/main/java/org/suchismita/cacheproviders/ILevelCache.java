package org.suchismita.cacheproviders;

import org.suchismita.models.ReadResponse;
import org.suchismita.models.WriteResponse;

import java.util.NoSuchElementException;

public interface ILevelCache<K,V> {
    ReadResponse<V> get(K key) throws NoSuchElementException;
    WriteResponse set(K key, V value);
    void stat();

}
