package com.Sanket.SpringbootTransaction.dto;

import com.Sanket.SpringbootTransaction.entity.Order;
import com.Sanket.SpringbootTransaction.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
