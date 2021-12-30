package ch.bissbert.hibernatebasics.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * a simple class having an {@link Integer} id, a list of items({@link Item}) and {@link String} name
 * TODO implement the attributes using hibernate Annotations
 * The id should be automatically incremented
 */
@Entity
public class Cupboard {
    @Id
    @Column
    private int id;

    //todo create annotation
    private List<Item> items;

    @Column
    private String name;
}
