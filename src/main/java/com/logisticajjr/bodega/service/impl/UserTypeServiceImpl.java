package com.logisticajjr.bodega.service.impl;

import com.logisticajjr.bodega.model.UserType;
import com.logisticajjr.bodega.repo.IGenericRepo;
import com.logisticajjr.bodega.repo.IUserTypeRepo;
import com.logisticajjr.bodega.service.IUserTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTypeServiceImpl extends CRUDImpl<UserType, Integer> implements IUserTypeService {

    private final IUserTypeRepo repo;

    @Override
    protected IGenericRepo<UserType, Integer> getRepo() {
        return repo;
    }
}
