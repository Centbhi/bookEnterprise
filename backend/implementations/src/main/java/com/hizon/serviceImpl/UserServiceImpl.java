package com.hizon.serviceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.UserData;
import com.hizon.model.User;
import com.hizon.repository.UserRepository;
import com.hizon.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<UserData, User> implements UserService{
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository repo, ModelMapper mapper){
        super(repo,mapper,UserData.class,User.class);
        this.userRepository = repo;
        this.mapper = mapper;
    } 

    @Override
    public User findByName (String username) {
        UserData entity = userRepository.findByName(username)
            .orElseThrow(() -> new RuntimeException("User not found with name: " + username));
        return mapper.map(entity, User.class);
    }
}
