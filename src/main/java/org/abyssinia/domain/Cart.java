package org.abyssinia.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartId;
	
	@Version
	@Column(name = "version")
	private int version = 0;

	@OneToOne(mappedBy = "cart", cascade = CascadeType.PERSIST)
	private User user;
	
	@OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CartItem> cartItemList = new HashSet<CartItem>();

	public Cart() {
		
	}
	
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	
	public Set<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(Set<CartItem> cartItems) {
		this.cartItemList = cartItems;
	}
}
