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
Create primary key as a composite key using @EmbeddedId which call as surrogate key
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
Suppose you have two address home address and office address. How we can store it in one table an with different column name.

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
	@Temporal(TemporalType.DATE) // to save date 	only
	private Date joinedDate;
	/*@Transient // this field will be ignored by hibernate
	private String address;*/
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "home_street_name")), // to override attribute/column in address 
			@AttributeOverride(name = "city", column = @Column(name = "home_city_name")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state_name")),
			@AttributeOverride(name = "pincode", column = @Column(name = "home_pin_code"))
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
}
```
How we can define BLOB and CLOB field in hibernate entity.

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
	@Temporal(TemporalType.DATE) // to save date 	only
	private Date joinedDate;
	/*@Transient // this field will be ignored by hibernate
	private String address;*/
	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "street", column = @Column(name = "home_street_name")), // to override attribute/column in address 
			@AttributeOverride(name = "city", column = @Column(name = "home_city_name")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state_name")),
			@AttributeOverride(name = "pincode", column = @Column(name = "home_pin_code"))
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
	@Lob // for large blob or clob objects
	private String description;
}
```
Now let's discuss about a scenario where Trasactions contains multiple Log. How we can maintain collection within same entity but different table.

```
@Entity (name = "tansactions")
@Table (name = "transactions")
public class Transactions {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "user_id")
	private int userId;
	@Column (name = "user_name")
	private String userName;
	@ElementCollection (fetch = FetchType.LAZY)
	@JoinTable (name = "transaction_logs",
				joinColumns = @JoinColumn(name = "USER_ID")
			)
	private Collection<Log> logs = new HashSet<>();
```
Here we have Transactions entity cotains set of logs using @ElementCollection. 
Fetching logs collection can have to strategy 
* Eggar 
* Lazzy
In case of eggar strategy we will fetch set of logs when we ask for the transactions
and in case of lazy hibernate will create a Proxy Object which fetch set of logs when it ask for.

```
@Embeddable
public class Log {
	@Column (name = "transaction_time")
	private Date txTime;
	@Column (name = "activity")
	private String activity;
```
