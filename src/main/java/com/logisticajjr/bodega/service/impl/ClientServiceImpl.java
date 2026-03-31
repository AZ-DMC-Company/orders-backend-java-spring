package com.logisticajjr.bodega.service.impl;

import com.logisticajjr.bodega.model.Client;
import com.logisticajjr.bodega.repo.IClientRepo;
import com.logisticajjr.bodega.repo.IGenericRepo;
import com.logisticajjr.bodega.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Client, Integer> implements IClientService {

    private final IClientRepo repo;

    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return repo;
    }
}
