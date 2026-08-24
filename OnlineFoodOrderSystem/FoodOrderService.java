package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.model.FoodOrder;

@Service
public class FoodOrderService {

    private List<FoodOrder> orders = new ArrayList<>();
    
    public FoodOrderService() {

        orders.add(new FoodOrder(1, "Shahid", "Pizza", 2, 500.0));
        orders.add(new FoodOrder(2, "Rahul", "Burger", 3, 450.0));
        orders.add(new FoodOrder(3, "Abhishek", "Biryani", 2, 600.0));
        orders.add(new FoodOrder(4, "Pooja", "Pasta", 1, 300.0));
        orders.add(new FoodOrder(5, "Ajay", "Dosa", 4, 280.0));
        orders.add(new FoodOrder(6, "Prashant", "Fried Rice", 2, 360.0));
        orders.add(new FoodOrder(7, "Priya", "Sandwich", 3, 330.0));
    }

    public FoodOrder addOrder(FoodOrder order) {
        orders.add(order);
        return order;
    }

    public List<FoodOrder> getAllOrders() {
        return orders;
    }

    public FoodOrder getOrderById(int orderId) {
    	for (FoodOrder order : orders) {
            if (order.getOrderId()==orderId) {
                return order;
            }
        }

        throw new OrderNotFoundException(
                "Order with ID " + orderId + " not found");
    }

    public FoodOrder updateOrder(int orderId, FoodOrder updatedOrder) {

        FoodOrder order=getOrderById(orderId);

        order.setCustomerName(updatedOrder.getCustomerName());
        order.setFoodItem(updatedOrder.getFoodItem());
        order.setQuantity(updatedOrder.getQuantity());
        order.setPrice(updatedOrder.getPrice());

        return order;
    }

    public String deleteOrder(int orderId) {
        FoodOrder order = getOrderById(orderId);
        orders.remove(order);
        return "Order deleted successfully";
    }

    public FoodOrder patchOrder(int orderId, FoodOrder updatedOrder) {
        FoodOrder order = getOrderById(orderId);

        if (updatedOrder.getCustomerName() != null) {
            order.setCustomerName(updatedOrder.getCustomerName());
        }

        if (updatedOrder.getFoodItem() != null) {
            order.setFoodItem(updatedOrder.getFoodItem());
        }

        if (updatedOrder.getQuantity() > 0) {
            order.setQuantity(updatedOrder.getQuantity());
        }

        if (updatedOrder.getPrice() != null) {
            order.setPrice(updatedOrder.getPrice());
        }

        return order;
    }

    public List<FoodOrder> getOrdersByCustomer(String customerName) {
        List<FoodOrder> result = new ArrayList<>();
        for (FoodOrder order : orders) {
            if (order.getCustomerName()
                    .equalsIgnoreCase(customerName)) {

                result.add(order);
            }
        }

        return result;
    }

    public List<FoodOrder> getOrdersByFood(String foodItem) {
        List<FoodOrder> result = new ArrayList<>();
        for (FoodOrder order : orders) {
            if (order.getFoodItem()
                    .equalsIgnoreCase(foodItem)) {

                result.add(order);
            }
        }

        return result;
    }

    public List<FoodOrder> getOrdersAbovePrice(double price) {
        List<FoodOrder> result = new ArrayList<>();
        for (FoodOrder order : orders) {
            if (order.getPrice() > price) {
                result.add(order);
            }
        }

        return result;
    }

    public double calculateTotal(int orderId) {
        FoodOrder order = getOrderById(orderId);
        return order.getQuantity() * order.getPrice();
    }
}
