package com.hizon.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.UserData;
import com.hizon.model.User;
import com.hizon.service.UserService;
import com.hizon.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
    
    private final UserRepository userRepo;
    private final ModelMapper mapper;

    public UserServiceImpl(UserRepository userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    public User create(User user){
        UserData userResult = mapper.map(user, UserData.class);
        UserData saved = userRepo.save(userResult);
        return mapper.map(saved,User.class);
    }

    public User read(Integer id){
        return mapper.map(userRepo.findById(id)
            .orElseThrow(()-> new RuntimeException("User not found with id: " + id)),User.class);
    }

    public List<User> readAll(){
        List<User> allUser = new ArrayList<User>();
        for(UserData data:userRepo.findAll()){
            allUser.add(mapper.map(data,User.class));
        }
        return allUser;
    }

    public User update(int id,User user){
        UserData userData = userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        user.setId(id);
        mapper.map(user,userData);
        UserData saved = userRepo.save(userData);
        return mapper.map(saved,User.class);
    }

    public void delete(Integer id){
        if(!userRepo.existsById(id)){
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepo.deleteById(id);
    }
}
