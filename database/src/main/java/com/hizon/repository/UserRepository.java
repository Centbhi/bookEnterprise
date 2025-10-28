package com.hizon.repository;
import com.hizon.entity.UserData;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserData,Integer>{}
    
