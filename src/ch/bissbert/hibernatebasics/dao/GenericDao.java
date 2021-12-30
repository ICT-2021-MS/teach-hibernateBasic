package ch.bissbert.hibernatebasics.dao;

import java.io.Serializable;

public class GenericDao<T, K extends Serializable> implements Dao<T, K> {
}
