package org.suchismita.strategies;

public interface IEvictionStrategy<K> {
    void keyAccessed(K key);
    void evictKey();
}
