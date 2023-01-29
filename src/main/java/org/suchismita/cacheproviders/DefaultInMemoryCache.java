package org.suchismita.cacheproviders;

import org.suchismita.exceptions.StorageFullException;
import org.suchismita.storage.IStorage;
import org.suchismita.strategies.IEvictionStrategy;
import java.util.NoSuchElementException;

public class DefaultInMemoryCache<K,V> implements ICacheProvider<K,V>{
    private final IEvictionStrategy<K> evictionStrategy;
    private final IStorage<K,V> storage;

    public DefaultInMemoryCache(IEvictionStrategy evictionStrategy, IStorage storage){
        this.evictionStrategy = evictionStrategy;
        this.storage = storage;
    }

    @Override
    public V get(K key) throws NoSuchElementException{
        if(storage.get(key) == null)
            throw new NoSuchElementException("No such element exist with key " + key);
        else{
            evictionStrategy.keyAccessed(key);
            return storage.get(key);
        }
    }

        @Override
        public void set(K key, V value) {
            try{
                this.storage.add(key,value);
                evictionStrategy.keyAccessed(key);
            }catch (StorageFullException e){
                evictionStrategy.evictKey();
                this.storage.add(key,value);
            }
        }

    @Override
    public double getCurrentUsage() {
        return this.storage.getUsage();
    }
}
