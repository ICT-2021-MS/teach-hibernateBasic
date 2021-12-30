package ch.bissbert.hibernatebasics.dao;

import java.io.Serializable;

/**
 * This class implements {@link Dao} generically using Hibernate
 * TODO EXPERT implement the methods you have available using only the documentation of hibernate itself
 * TODO INTERMEDIARY-EXPERT implement all methods using the given documents
 * @param <T> The class of instances to be managed
 * @param <K> The Type of id the class is managed by. MUST implement {@link Serializable}
 */
public class GenericDao<T, K extends Serializable> implements Dao<T, K> {
}
