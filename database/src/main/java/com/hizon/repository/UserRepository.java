package com.hizon.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hizon.entity.UserData;


public interface UserRepository extends JpaRepository<UserData,Integer>{
    Optional<UserData> findByName(String name);
}
    
