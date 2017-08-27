package com.shoppingcart.app.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.dao.OrderRepository;
import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.services.OrderService;

@RestController
public class OrderRestController {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderRestController.class);
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value="/getOrder", method=RequestMethod.GET)
	public Order getOrder(@RequestParam("orderId") String orderId){
		LOGGER.info("Fetching order details of order num "+orderId);
		return orderRepo.findOne(orderId);
	}
	
	@RequestMapping(value="/getMyOrders", method=RequestMethod.GET)
	public List<Order> getMyAllOrders(@RequestParam("userId") String userId){
		LOGGER.info("Fetching orders for user "+userId);
		return orderService.getUserAllOrders(userId);
	}
	
	@RequestMapping(value="/placeAnOrder", method=RequestMethod.POST)
	public String placeAnOrder(@RequestBody Order order){
		return orderService.placeOrder(order);
	}
	
	@RequestMapping(value="/addOrderTrackingId", method=RequestMethod.PUT)
	public Order addTrackingIdForOrder(@RequestParam("orderId")String orderId, @RequestParam("trackingId")String trackingId){
		LOGGER.info("Updating tracking id as "+trackingId+" for order id as "+orderId);
		return orderService.updateTrackingId(orderId, trackingId);
	}
	
	@RequestMapping(value="/updateOrderStatus", method=RequestMethod.PUT)
	public Order updateOrderStatus(@RequestParam("orderId")String orderId, @RequestParam("status")String orderStatus){
		LOGGER.info("Updating order status as "+orderStatus+" for order id as "+orderId);
		return orderService.updateOrderStatus(orderId, orderStatus);
	}
	
	@RequestMapping(value="/cancelOrder", method=RequestMethod.PUT)
	public Order cancelOrder(@RequestParam("orderId")String orderId){
		LOGGER.info("Cancelling order for order id "+orderId);
		return orderService.cancelOrder(orderId);
	}
}
