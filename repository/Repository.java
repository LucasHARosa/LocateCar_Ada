package repository;

import java.util.List;

public interface Repository<T> {
    void add(T item);
    void remove(T item);
    void update(T anterior, T novo);
    T get(String id);
    List<T> getAll();

}
