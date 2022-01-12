---
theme: uncover
paginate: true
backgroundColor: #faf4f
title: Hibernate Basics
author: Bissbert
class: invert
marp: true
---

![height:150px](hibernate-icon.svg)
# Hibernate Basics

---

## Contents

* Level Determination
* Basic Introduction to Hibernate
* Config of a hibenrate project
* Class Annotation
  * Basics
  * Relations
* DAO

---

## Level Determination

Please follow the link in the chat and to the quiz
| Points     | level        |
| ---------- | ------------ |
| &#62; 90 % | expert       |
| 50-90 %    | intermediary |
| &#60; 50 % | beginner     |

---

<!-- footer: <p>* = Object Relation Mapping</p>-->

## Basic Introduction

Hibernate is...
- an ORM<sup>*</sup> framework
- used for db connections

---

<!-- footer: >-->

## Configurating a hibernate Project

File used: `hibernate.cfg.xml`

---

### Setting up the connection

```xml
<!-- Database connection settings -->
<property name="connection.driver_class"></property>
<property name="connection.url"></property>
<property name="connection.username"></property>
<property name="connection.password"></property>
```

<small>MySQL Driver(under jdk 8): `com.mysql.jdbc.Driver`</small>
<small>url looks like: `jdbc:<dbtype>://<url>/<database>`</small>

---
### Class Mapping

We have to set the mapping to each class like this:

```xml
<mapping class="model.Person">
```

---

## Class Annotation

There are a few basic Annotations used often and some more complex ones.

---

### Basic Annotations

- Classes
- Fields

---

#### Class Annotations

| Annotation | Meaning                      |
| ---------- | ---------------------------- |
| Entity     | Marks as Persistance Entity  |
| Table      | Used to set Table name in DB |

---

#### Example

```java
@Entity
@Table(name="PERSON")
class Person {
```

---

#### Field Annotations

| Annotation | Meaning                                                    |
| ---------- | ---------------------------------------------------------- |
| Column     | Used to set name of columun in DB                          |
| Id         | Marks attribute as PK                                      |
| Basic      | Marks attribute as basic data <small>(no relation)</small> |
| Lob        | Marks as BLOB in DB                                        |

---

#### Example

```java
@Entity
@Table(name="PERSON")
class Person {
    @Id
    @Column(name="Id")
    private int id;

    @Basic
    @Column(name="Name")
    private String name;

    @Lob
    @Column(name="Profile_Picture")
    private byte[] picture;
}
```

---

<!-- color : white -->

![bg](gradient.png)

## Intermediary may come back to plenum for more complicated Annotations

---

<!-- color : default -->

## Advanced Annotations
| Annotation     | Meaning                                                                    |
| -------------- | -------------------------------------------------------------------------- |
| GeneratedValue | generates the value                                                        |
| ManyToOne      | referencing a single object </br><sup>used in mappedBy of OneToMany</sup>  |
| JoinColumn     | The column containing the FK                                               |
| OneToMany      | referencing a list of objects with FK in opposite object set by `mappedBy` |

---

#### Example

```java
@Entity
@Table(name="PERSON")
class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @ManyToOne
    @JoinColumn(name="Father_Id")
    private Person father;

    @OneToMany(mappedBy="father")
    private List<Person> children;
}
```

---

## DAO

- Data Access Object
- Handles the Transactions with the DB
- should always implement CRUD

---

![bg](gradient2.png)

# DEMO

Intermediary may work alone again