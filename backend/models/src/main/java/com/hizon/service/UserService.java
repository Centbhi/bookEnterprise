package com.hizon.service;
import java.util.List;

import com.hizon.model.User;

public interface UserService {
    List<User> readAll() throws Exception;
    User create(User user) throws Exception;
    User read(Integer id) throws Exception;
    User update(int id,User user) throws Exception;
    void delete(Integer id) throws Exception;
}
