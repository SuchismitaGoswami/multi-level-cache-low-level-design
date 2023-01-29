package org.suchismita.models;

public class ReadResponse<V> {
  private int readResponseTime;
  private V value;

    public ReadResponse(int readResponseTime, V value) {
        this.readResponseTime = readResponseTime;
        this.value = value;
    }

    public int getReadResponseTime() {
        return readResponseTime;
    }

    public V getValue() {
        return value;
    }
}
