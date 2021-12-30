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
To configure hibernate you have to make changes in the hibernate.cfg.xml, such as setting the user and password.</br>
Further instructions on how to configure hibernate can be found in the file as comments


### Configure the Classes
Let's begin with the easier part of annotating the data classes.
The basic instructions such as marking the entities as tables and setting basic columns have already been done,
so you can concentrate on the more difficult tasks.

Some additional info:

To create the connection between the 2 classes/tables in a list you have to use the @OneToMany Annotation

<details>
<summary>
Hint 1
</summary>
To set the name of an attribute us the @Column annotation.
</details>

<details>
<summary>
Hint 2
</summary>
To create an auto incrementing field use the @GeneratedValue annotation. You also need to set the strategy.
</details>

<details>
<summary>
Hint 3
</summary>
For the many to one relation in cupboard you have to create a opposing attribute with a one to many mapping. Here you then also have to set the join column.
</details>


### Dao
Finally, we come to the dao class. an Interface is already created, but you may do whatever you want with the implementation class.
We will just create a dao class for the Cupboard class.

To create a new Session we must first have a SessionFactory.
This can be produces using the Configuration class.
Here we can either just say .configure().build(); or also pass a path to the configuration (not needed in this example)

If we want to correctly implement a hibernate connection for create, update and delete we have to work with the Transaction class.
Using the Transaction class we open a transaction with the server,
meaning we create a connection to the current state of the DB and will only be able to work with this state.
To then upload this data or get fresh data again we have to commit this transaction which kind of functions like a flush pushing all our changes to the db in an instant.
When working with transactions this is also the step where you should first get a generated value. (or at least use it)

When working with the getAll we have to create a query to access a list.

<details>
<summary>
Hint
</summary>
For fetching all data from the server you should create a query using the classname of the type.
</details>