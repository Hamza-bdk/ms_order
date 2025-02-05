package com.wafa.ms_order.listener;

import com.wafa.ms_order.model.Order;

public record OrderCreationEvent(Order savedOrder){}
