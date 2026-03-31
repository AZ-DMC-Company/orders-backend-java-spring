package com.logisticajjr.bodega.service.impl;

import com.logisticajjr.bodega.model.Product;
import com.logisticajjr.bodega.repo.IGenericRepo;
import com.logisticajjr.bodega.repo.IProductRepo;
import com.logisticajjr.bodega.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer> implements IProductService {

    private final IProductRepo repo;

    @Override
    protected IGenericRepo<Product, Integer> getRepo() {
        return repo;
    }
}
