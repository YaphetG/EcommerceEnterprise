package org.abyssinia.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.abyssinia.validation.EmptyOrSize;
import org.abyssinia.validation.NullMinNumber;
import org.hibernate.validator.constraints.NotEmpty;


@Entity(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 16)
	@EmptyOrSize(min = 5, max = 9, message = "{EmptyOrSize}")
	private String firstName;

	@Column(length = 16)
	@EmptyOrSize(min = 5, max = 9, message = "{EmptyOrSize}")
	private String lastName;

	@NullMinNumber(value = 16)
	private Integer age;

	@Column(length = 32)
	@NotEmpty
	private String title;

	@NullMinNumber(value = 6)
	private Integer userNumber;

	@OneToOne(fetch=FetchType.EAGER,  cascade = CascadeType.ALL) 
 	@JoinColumn(name="user_id") 
 	UserCredentials userCredentials;
 	

	@OneToOne(fetch=FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
     private Address address;
	
	@OneToMany
	private List<Order> orders = new ArrayList<Order>();
	
	@OneToOne(fetch=FetchType.LAZY,  cascade = CascadeType.PERSIST) 
	@JoinColumn(name="cart_id") 
	private Cart cart;
	
	@OneToOne(fetch=FetchType.LAZY,  cascade = CascadeType.ALL)
	@JoinColumn(name="payment_id")
	private OrderPayment payment;

	public User() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddresse(Address address) {
		this.address = address;
	}


	public Integer getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(Integer userNumber) {
		this.userNumber = userNumber;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}
 	
 	public boolean isAdmin()
 	{
 		if (this.getUserCredentials().isAdmin())
 			return true;
 		return false;
 	}
	
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

}
