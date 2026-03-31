package com.logisticajjr.bodega.service.impl;

import com.logisticajjr.bodega.model.Order;
import com.logisticajjr.bodega.model.OrderDetail;
import com.logisticajjr.bodega.repo.IGenericRepo;
import com.logisticajjr.bodega.repo.IOrderRepo;
import com.logisticajjr.bodega.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends CRUDImpl<Order, Integer> implements IOrderService {

    private final IOrderRepo repo;

    @Override
    protected IGenericRepo<Order, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Order> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.DESC, "modifiedAt"));
    }

    /**
     * El lado dueño del FK es OrderDetail.order; JSON no rellena esa referencia.
     * Sin esto, cascade inserta detalles con id_order null.
     */
    private static void linkDetailsToOrder(Order order) {
        if (order.getOrderDetail() == null) {
            return;
        }
        for (OrderDetail detail : order.getOrderDetail()) {
            detail.setOrder(order);
        }
    }

    @Override
    public Order save(Order order) {
        linkDetailsToOrder(order);
        return repo.save(order);
    }

    @Override
    public Order update(Order order, Integer id) throws Exception {
        linkDetailsToOrder(order);
        return super.update(order, id);
    }
}
