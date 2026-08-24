package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.FoodOrder;
import com.example.demo.service.FoodOrderService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class FoodOrderController {

    private FoodOrderService service;
    public FoodOrderController(FoodOrderService service) {
        this.service = service;
    }

    @PostMapping
    public FoodOrder addOrder( @Valid @RequestBody FoodOrder order) {
        return service.addOrder(order);
    }

    @GetMapping
    public List<FoodOrder> getAllOrders() {
        return service.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public FoodOrder getOrder(@PathVariable int orderId) {
        return service.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public FoodOrder updateOrder(@PathVariable int orderId,@Valid @RequestBody FoodOrder order) {
        return service.updateOrder(orderId, order);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable int orderId) {
        return service.deleteOrder(orderId);
    }

    @PatchMapping("/{orderId}")
    public FoodOrder patchOrder(@PathVariable int orderId, @RequestBody FoodOrder order) {
        return service.patchOrder(orderId, order);
    }

    @GetMapping("/customer/{customerName}")
    public List<FoodOrder> getOrdersByCustomer(@PathVariable String customerName) {
        return service.getOrdersByCustomer(customerName);
    }

    @GetMapping("/food/{foodItem}")
    public List<FoodOrder> getOrdersByFood(@PathVariable String foodItem) {
        return service.getOrdersByFood(foodItem);
    }

    @GetMapping("/price/{price}")
    public List<FoodOrder> getOrdersAbovePrice(@PathVariable double price) {
        return service.getOrdersAbovePrice(price);
    }

    @GetMapping("/total/{orderId}")
    public String calculateTotal(@PathVariable int orderId) {
        double total = service.calculateTotal(orderId);
        return "Total Order Amount: ₹" + total;
    }
}
