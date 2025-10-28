package com.hizon.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hizon.entity.UserData;


public interface UserRepository extends JpaRepository<UserData,Integer>{}
    
