package com.Sanket.SpringbootTransaction.service;

import com.Sanket.SpringbootTransaction.dto.OrderRequest;
import com.Sanket.SpringbootTransaction.dto.OrderResponse;

public interface OrderService {
    OrderResponse placeOrder(OrderRequest orderRequest);
}
