package com.logisticajjr.bodega.service.impl;

import com.logisticajjr.bodega.exception.ModelNotFoundException;
import com.logisticajjr.bodega.repo.IGenericRepo;
import com.logisticajjr.bodega.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public T save(T t) {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID " + id + " NO EXISTE"));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) {
        return getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID " + id + " NO EXISTE"));
    }

    @Override
    public void delete(ID id) {
        getRepo().findById(id).orElseThrow( () -> new ModelNotFoundException("ID " + id + " NO EXISTE"));
        getRepo().deleteById(id);
    }
}
