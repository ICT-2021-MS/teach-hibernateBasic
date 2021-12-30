# Basic Hibernate Configuration

In this class we will look at how to configure a hibernate project and create a basic usecase.

## Tasks

### import library

First we have to be sure we have the hibernate jar. If you do not have it please just download it under the
following link: [releases](https://hibernate.org/orm/releases/)

There download the latest stable release in zip form. This should then contain all libs you need as well as the
documentation.

To import the libraries add the releases folder under libs to your classpath. (for the base lib)</br>
Under the documentation/quickstart folder you will find many example projects that can be used as references.</br>
For this tutorial please use "annotations" or "basic" as a reference.

### Configure Hibernate

To configure hibernate you have to make changes in the hibernate.cfg.xml, such as setting the user and password.</br>
Further instructions on how to configure hibernate can be found in the file as comments

### Configure the Classes

Configuring a data class isn't as complicated as it may seem at first glance. We will go through it together step by step
so at the end you will understand it fully.

Let's begin with the marking of the classes. These should be marked using the `@Entity` and the `@Table` annotations.

```java
@Entity
@Table(name = "cupboard")
public class CupBoard {
...
}
```

Next we will mark all attributes we have as columns. This isn't obligatory but is visually much more appealing as you
can also set the name of the attribute in the DB.

```java
@Column(name = "Name")
private String name;
```

After having marked all columns we will now look at the automatically incremented ids. First we have to mark an id
with `@Id`. This lets hibernate know which element to use. From here on we can use the `@GeneratedValue` annotation with
a set strategy:

```java
@Id
@Column(name = "id")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
```

Almost last we have the list left. Here we are going to work with the `@OneToMany` annotation setting the mappedBy
attribute to the name of the coinciding variable in the opposite class. As implied by the attribute name the relation
then has to be mapped in said variable using the `@ManyToOne` and `@JoinCollumn` annotations.

```java
@Entity
@Table
public class Cupboard {
    @Id
    private int id;

    @OneToMany(mappedBy = "cupboard")
    private List<Item> items;
}

@Entity
@Table
public class Item {
    @Id
    private int id;

    @JoinColumn(name = "Cupboard_ID")
    @ManyToOne
    private Cupboard cupboard;
}
```

And finally we have made these attributes and relations accessible to hibernate. If we use proper data hiding we should
have all attributes as private and now only have to create getters and setters for them. in IntelliJ there can be
automatically generated using `⌘ + N` or `WIN + Insert`

### Dao

Finally, we come to the dao class. an Interface is already created, but you may do whatever you want with the
implementation class. We will just create a dao class for the Cupboard class.

To create a new Session we must first have a SessionFactory. This can be produces using the Configuration class. Here we
can either just say `.configure().build();` or also pass a path to the configuration (not needed in this example)

```java
public class CupboardDao implements Dao<Cupboard, Integer> {
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}
```

The correct way would be to now implement the Closable Interface, have a factory for every instance and the close it
after the dao has been used. But as we do not care about the connections still open or managed we can ignore it and move
on to the next step.

As we have implemented the Dao Interface we also have to actually implement the methods provided by it. We'll go through
each type of method individually.

#### Simple Get

A simple get method only required a Session to exist and them from there fetch the data. This can be done using
the `get` method. This method also required a class which is the class of the object we want to receive.

```java
private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

@Override
public Cupboard get(Integer id) {
    Cupboard cupboard = null;
    try (Session session = sessionFactory.openSession()) {
        cupboard = session.get(Cupboard.class, id);
    }
    return cupboard;
}
```

#### GetAll using a Query

When trying to fetch multiple results from the database we have to create a `Query` object and use it to fetch the
results. Inside these queries we have to use a language called HQL it is very similar to SQL but some important
differences such as having to use the name of the class instead of the table.

```java
private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

@Override
public Cupboard getAll() {
    List<Cupboard> cupboards = null;
    try (Session session = sessionFactory.openSession()) {
        cupboards = session.createQuery("FROM Cupboard", Cupboard.class);
    }
    return cupboards;
}
```

#### Management Methods (create, update & delete)

With the CUD operations we get one more element we have to build in. This is the `Transaction` class to create a transaction with the server.

A transaction with the server creates a temporary copy of its contents which then is used when sending commands to the server.
After finishing our business with the server we then have to tell it to 1. update the tables accordingly and 2. to show us new data, which is done using the `commit` command.

I will make an example using insert:

```java
private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

@Override
public void insert(Cupboard cupboard) {
    try (Session session = sessionFactory.openSession()) {
        Transaction transaction = session.beginTransaction();
        session.save(cupboard);
        transaction.commit();
    }
}
```
