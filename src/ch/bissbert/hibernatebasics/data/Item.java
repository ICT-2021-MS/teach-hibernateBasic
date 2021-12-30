package ch.bissbert.hibernatebasics.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * a simple class that only contains an {@link Integer} id and a {@link String} name
 * TODO implement the attributes using hibernate Annotations
 * the id should be automatically incremented
 */
@Entity
public class Item {
    @Id
    @Column
    private int id;

    @Column
    private String name;
}
