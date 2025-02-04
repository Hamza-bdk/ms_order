package com.wafa.ms_order.service;

import com.wafa.ms_order.common.exception.NotFoundException;
import com.wafa.ms_order.model.Store;

public interface StoreService {

    Store findLastModifiedByName(String name) throws NotFoundException;
}
