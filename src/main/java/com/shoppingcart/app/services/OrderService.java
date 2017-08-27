package com.shoppingcart.app.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.dao.OrderRepository;
import com.shoppingcart.app.dao.UserRepository;
import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.model.User;

@Service
public class OrderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
    private MongoTemplate mongoTemplate;
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	public List<Order> getUserAllOrders(String userId){
		return userRepo.findOne(userId).getOrders();
	}
	
	public String placeOrder(Order order){
		try{
			orderRepo.insert(order);
			User user = userRepo.findOne(order.getUserId());
			user.getOrders().add(order);
			userRepo.save(user);
			return "Success";
		} catch(Exception e){
			return "Error: Order Placing failed due to "+e.getMessage();
		}
	}

	public Order updateTrackingId(String orderId, String trackingId) {
		Order order = orderRepo.findOne(orderId);
		if(null != order){
			order.setTrackingId(trackingId);
			try{
				orderRepo.save(order);
				return order;
			} catch(Exception e){
				LOGGER.error("Error. Tracking Id update failed due to "+e.getMessage());
				return null;
			}
		} else {
			LOGGER.error("No Order found against order Id - "+orderId);
			return null;
		}
	}

	public Order updateOrderStatus(String orderId, String orderStatus) {
		Order order = orderRepo.findOne(orderId);
		if(null != order){
			order.setStatus(orderStatus);
			try{
				orderRepo.save(order);
				return order;
			} catch(Exception e){
				LOGGER.error("Error. Status update failed due to "+e.getMessage());
				return null;
			}
		} else {
			LOGGER.error("No Order found against order Id - "+orderId);
			return null;
		}
	}

	public Order cancelOrder(String orderId) {
		Order order = orderRepo.findOne(orderId);
		if(null != order){
			order.setStatus("Cancelled");
			order.setTrackingId(null);
			try{
				orderRepo.save(order);
				return order;
			} catch(Exception e){
				LOGGER.error("Error. Status update failed due to "+e.getMessage());
				return null;
			}
		} else {
			LOGGER.error("No Order found against order Id - "+orderId);
			return null;
		}
	}
	
}
