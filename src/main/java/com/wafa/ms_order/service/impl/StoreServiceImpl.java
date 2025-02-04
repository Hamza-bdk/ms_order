package com.wafa.ms_order.service.impl;

import com.wafa.ms_order.common.exception.NotFoundException;
import com.wafa.ms_order.model.Store;
import com.wafa.ms_order.repository.StoreRepository;
import com.wafa.ms_order.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    @Override
    public Store findLastModifiedByName(String name) throws NotFoundException {
        return storeRepository.findLastModifiedByName(name)
                .orElseThrow(() -> new NotFoundException(String.format("No store with name '{}'", name)));
    }
}
