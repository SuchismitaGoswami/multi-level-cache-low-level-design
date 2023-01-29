package org.suchismita.services;

import org.suchismita.cacheproviders.ILevelCache;
import org.suchismita.models.ReadResponse;
import org.suchismita.models.WriteResponse;

public class MultiLevelCache<K,V> {
    private ILevelCache<K,V>  L1Cache;
    public MultiLevelCache(ILevelCache<K,V> level1Cache){
        this.L1Cache = level1Cache;
    }
    V get(K key){
        ReadResponse<V> response = this.L1Cache.get(key);
        System.out.println("Total time taken to read " + response.getReadResponseTime());
        return response.getValue();
    }

    void set(K key, V value){
        WriteResponse response = this.L1Cache.set(key, value);
        System.out.println("Total time taken to write " + response.getWriteResponseTime());
    }
}
