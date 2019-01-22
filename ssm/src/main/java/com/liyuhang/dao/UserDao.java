package com.liyuhang.dao;

import com.liyuhang.domian.User;

import java.util.List;

public interface UserDao {

    List <User>  findAll();

    List<User> moFuFind(User user);

    List<User> zhiJieFind(String usernmae);

    List<User> conditionFind(User user);

    List<User> findInIds(User user);
}
