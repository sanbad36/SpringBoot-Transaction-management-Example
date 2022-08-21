package com.Sanket.SpringbootTransaction.service.impl;

import com.Sanket.SpringbootTransaction.entity.Order;
import com.Sanket.SpringbootTransaction.entity.Payment;
import com.Sanket.SpringbootTransaction.exception.PaymentException;
import com.Sanket.SpringbootTransaction.service.OrderService;
import com.Sanket.SpringbootTransaction.dto.OrderRequest;
import com.Sanket.SpringbootTransaction.dto.OrderResponse;
import com.Sanket.SpringbootTransaction.repository.OrderRepository;
import com.Sanket.SpringbootTransaction.repository.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

        if(!payment.getType().equals("DEBIT")){
            throw new PaymentException("Payment card type do not support");
        }

        payment.setOrderId(order.getId());
        paymentRepository.save(payment);

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderTackingNumber(order.getOrderTackingNumber());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setMessage("SUCCESS");
        return orderResponse;
    }
}
