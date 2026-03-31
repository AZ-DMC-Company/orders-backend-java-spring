package com.logisticajjr.bodega.service;

import com.logisticajjr.bodega.model.User;

public interface IUserService extends ICRUD<User, Integer> {

    User login(String username, String password) throws Exception;

}
