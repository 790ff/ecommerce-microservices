package com.ecommerce.orderservice.service;

import com.ecommerce.orderservice.model.Order;
import com.ecommerce.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        String url = "http://localhost:8081/api/products/" + order.getProductId();
        var product = restTemplate.getForObject(url, Object.class);

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        order.setStatus("PENDING");
        return orderRepository.save(order);
    }
}
