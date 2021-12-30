package ch.bissbert.hibernatebasics.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * a simple class that only contains an {@link Integer} id and a {@link String} name
 * the id should be automatically incremented
 */
@Entity
public class Item {
    private int id;

    private String name;
}
