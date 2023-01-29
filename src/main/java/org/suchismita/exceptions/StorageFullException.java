package org.suchismita.exceptions;

public class StorageFullException extends RuntimeException{
    public StorageFullException(int capacity){
        super("Storage with capacity : " + capacity + "is full!");
    }
}
