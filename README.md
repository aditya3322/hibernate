# Exploring Hibernate

This is project contains some useful hibernate internals for understanding basics of Java Persistent Apis with hibernate 

## Version
Hibernate Version: 5.3.2
Postgresql Version: 9.1

## Basic Concepts

Define User @Entity with @Embeddable Address which will put data user table.

```java
@Entity
@Table(name = "users")
public class User {
	// natural (primary) keys are primary keys we have to provide the value
	// unique keys are surrogate keys and it does'nt have business use case.
	@Id // @EmbeddedId for primary key contains two fields
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;	
}
``` 
Address Embeddable object: 
```java
@Embeddable
public class Address {

	@Column (name = "street_name")
	private String street;
	@Column (name = "city_name")
	private String city;
	@Column (name = "state_name")
	private String state;
	@Column (name = "pin_code")
	private String pincode;
}
``` 
Create primary key was a composite key using @EmbeddedId which call as surrogate key
```java
@Entity
@Table(name = "users")
public class User {
	// natural (primary) keys are primary keys we have to provide the value
	// unique keys are surrogate keys and it does'nt have business use case.
	@EmbeddedId for primary key contains two fields
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
}
```
To ignore the field in the entity JPA provides @Transient annotation
```java
@Embeddable
public class Address {
	@Transient
	private String street;
	@Column (name = "city_name")
	private String city;
}
```


