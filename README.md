# Exploring Hibernate

This is project contains some useful hibernate internals for understanding basics of Java Persistent Apis with hibernate 

## Version
Hibernate Version: 5.3.2
Postgresql Version: 9.1

## Scenario 1

Define User @Entity with @Embeddable Address which will put data user table.

```
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
```
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


