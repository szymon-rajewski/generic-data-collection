package com.szymonrajewski.collection;

import java.util.Optional;

public interface DataCollection<T> {
    void add(Optional<T> element) throws InvalidCollectionElementException;
    void remove(Optional<T> element) throws InvalidCollectionElementException, NotFoundCollectionElementException;
}
