# Basic Hibernate Configuration
In this class we will look at how to configure a Hibernate project and create a basic usecase.

## Tasks


### import library
First of all we have to be sure we have the hibernate jar.
If you do not have it please just download it under the following link: [releases](https://hibernate.org/orm/releases/)

There download the latest stable release in zip form.
This should then contain all libs you need as well as the documentation.

To import the libraries add the releases folder under libs to your classpath. (for the base lib)</br>
Under the documentation/quickstart folder you will find many example projects that can be used as references.</br>
For this tutorial please use "annotations" or "basic" as a reference. 


### Configure Hibernate
As this is the expert group I will help you if you ask, but you first have to try finding it yourself.</br>
<details>
    <summary>
        Tip
    </summary>
    There may be some config files in the example projects?
</details>


### Configure the Classes
Let's begin with the easier part of annotating the data classes. Further instructions are in the code</br>

<details>
    <summary>
        Tip 1
    </summary>
    in the annotations example project they use annotations
</details>

<details>
<summary>
Tip 2
</summary>
To configure a class as a table you have to set the following attributes:

| Annotation | Description                                                          |
|:-----------|:---------------------------------------------------------------------|
| Entity     | Marks the class as a Persistence Entity                              |
| Table      | Marks the class as a table and can set the name in the DB (optional) |
| Id         | Marks an attribute as the identifier(pk) in the DB                   |

</details>

<details>
<summary>
Tip 3
</summary>
To set the name of an attribute us the @Column annotation.

If this is the tip you need please join the intermediary group.
</details>

<details>
<summary>
Tip 4
</summary>
To create an autoincrementing field use the @GeneratedValue annotation. You also need to set the strategy.
</details>

<details>
<summary>
Tip 5
</summary>
For the many to one relation in cupboard you have to create a opposing attribute with a one to many mapping. Here you then also have to set the join column.
</details>


### Dao
Finally, we come to the dao class. an Interface is already created, but you may do whatever you want with the implementation class.
As you are the experts and should already know how to create a basic DAO for a class you will create a generic class.
This means it should work with any correctly annotated class.

As questions here often are very case centric please ask me directly if not found below.

<details>
<summary>
Tip 1
</summary>
You must create a SessionFactory using the builder and then first configure it before building.
</details>

<details>
<summary>
Tip 2
</summary>
For fetching all data from the server you should create a query using the classname of the type.
</details>