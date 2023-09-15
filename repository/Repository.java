package repository;

import java.util.List;

public interface Repository<T> {
    void add(T item);
    void remove(T item);
    void update(T update);
    T get(String id);
    List<T> getAll();

}
