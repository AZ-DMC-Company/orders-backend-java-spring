package com.logisticajjr.bodega.repo;

import com.logisticajjr.bodega.model.User;

public interface IUserRepo extends IGenericRepo<User,Integer> {

    User findOneByUsername(String username);
}
