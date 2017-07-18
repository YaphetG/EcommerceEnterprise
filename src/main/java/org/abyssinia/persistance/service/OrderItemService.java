package org.abyssinia.persistance.service;

import java.util.List;

import org.abyssinia.domain.OrderItem;

public interface OrderItemService {
	public void save( OrderItem orderItem);
	public void update(OrderItem orderItem);
	public List<OrderItem> findAll(); 
	public OrderItem findOne(Long id);

}
