package org.suchismita.cacheproviders;

import org.suchismita.models.Level;
import org.suchismita.models.ReadResponse;
import org.suchismita.models.WriteResponse;

import java.util.NoSuchElementException;

public class DefaultLevelCache<K,V> implements ILevelCache<K,V>{

    private Level level;
    private ICacheProvider<K,V> cache;

    private ILevelCache<K,V> nextLevelCache;
    @Override
    public ReadResponse<V> get(K key) throws NoSuchElementException{
        ReadResponse<V> response = null;
        try {
            response = new ReadResponse<V>(this.level.readTime(), this.cache.get(key));
        }catch (NoSuchElementException error){
            if(this.nextLevelCache == null)
                throw new NoSuchElementException("No element exists with key: " + key);
            ReadResponse<V> readResponse = this.nextLevelCache.get(key);
            this.cache.set(key, readResponse.getValue());
            response = new ReadResponse<V>((this.level.readTime() + this.level.writeTime() + readResponse.getReadResponseTime()), readResponse.getValue());
        }
        return response;
    }

    @Override
    public WriteResponse set(K key, V value) {
        WriteResponse response = null;
        try{
            V result = this.cache.get(key);
            if(result == value)
                response = new WriteResponse(this.level.readTime());
        }catch (NoSuchElementException e){
            // nothing to do
        }
        if(response == null) {
            this.cache.set(key, value);
            WriteResponse nextLevelResponse = this.nextLevelCache.set(key, value);
            response = new WriteResponse(this.level.writeTime() + this.level.readTime() + nextLevelResponse.getWriteResponseTime());
        }
        return  response;
    }

    @Override
    public void stat() {

    }
}
