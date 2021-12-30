package ch.bissbert.hibernatebasics.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * a simple class having an {@link Integer} id, a list of items({@link Item}) and {@link String} name
 * The id should be automatically incremented
 */
@Entity
public class Cupboard {

    private int id;

    private List<Item> items;

    private String name;
}
