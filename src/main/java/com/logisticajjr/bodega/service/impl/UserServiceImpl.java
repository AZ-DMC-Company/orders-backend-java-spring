package com.logisticajjr.bodega.service.impl;

import com.logisticajjr.bodega.model.User;
import com.logisticajjr.bodega.repo.IGenericRepo;
import com.logisticajjr.bodega.repo.IUserRepo;
import com.logisticajjr.bodega.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer> implements IUserService {

    private final IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }

    @Override
    public User login(String username, String password) {
        return repo.findById(1).orElse(null);
    }
}
