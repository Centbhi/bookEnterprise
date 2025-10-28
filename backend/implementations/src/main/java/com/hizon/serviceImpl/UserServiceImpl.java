package com.hizon.serviceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.hizon.entity.UserData;
import com.hizon.model.User;
import com.hizon.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserData, User> implements UserService{
    public UserServiceImpl(JpaRepository<UserData,Integer> repo, ModelMapper mapper){
        super(repo,mapper,UserData.class,User.class);
    }
}
