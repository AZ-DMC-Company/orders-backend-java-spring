package com.logisticajjr.bodega.service.impl;

import com.logisticajjr.bodega.model.OrderDetail;
import com.logisticajjr.bodega.repo.IGenericRepo;
import com.logisticajjr.bodega.repo.IOrderDetailRepo;
import com.logisticajjr.bodega.service.IOrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl extends CRUDImpl<OrderDetail, Integer> implements IOrderDetailService {

    private final IOrderDetailRepo repo;

    @Override
    protected IGenericRepo<OrderDetail, Integer> getRepo() {
        return repo;
    }
}
