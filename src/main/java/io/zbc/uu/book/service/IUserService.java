package io.zbc.uu.book.service;

import io.zbc.uu.book.entity.User;

public interface IUserService {

    User getUserByNameAndPassword(User user);

}
