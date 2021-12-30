package ch.bissbert.hibernatebasics.data;

import java.util.List;

/**
 * a simple class having an {@link Integer} id, a list of items({@link Item}) and {@link String} name
 * TODO implement the attributes using hibernate Annotations
 * The id should be automatically incremented
 */
public class Cupboard {
    private int id;
    private List<Item> items;
    private String name;
}
