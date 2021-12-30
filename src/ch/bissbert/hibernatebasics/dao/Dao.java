package ch.bissbert.hibernatebasics.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface that promises the default CRUD operations
 * @param <T> The class of instances to be managed
 * @param <K> The Type of id the class is managed by. MUST implement {@link Serializable}
 */
public interface Dao <T, K extends Serializable> {

    /**
     * returns an instance of {@link CupboardDao} with fitting classes
     * @return a cupboard dao
     */
    static CupboardDao getDao(){
        return new CupboardDao();
    }

    /**
     * retrieves a object of type {@link T} by its ID of {@link K}
     * @param k identifier of the class to be searched by
     * @return instance associated with the param
     */
    T get(K k);

    /**
     * retrieves all Instances of given type
     * @return all instances of given type
     */
    List<T> getAll();

    /**
     * deletes the given instance from persistence
     * @param t instance to be removed from persistence
     */
    void delete(T t);

    /**
     * updates the given instance in persistence
     * @param t instance to be updated in persistence
     */
    void update(T t);

    /**
     * inserts an instance to persistence
     * @param t instance to be saved to persistence
     */
    void insert(T t);
}
