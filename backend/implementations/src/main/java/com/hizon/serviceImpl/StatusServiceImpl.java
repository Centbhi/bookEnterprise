package com.hizon.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.StatusData;
import com.hizon.model.Status;
import com.hizon.service.StatusService;
import com.hizon.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{
    
    private final StatusRepository statusRepo;
    private final ModelMapper mapper;

    public StatusServiceImpl(StatusRepository statusRepo, ModelMapper mapper) {
        this.statusRepo = statusRepo;
        this.mapper = mapper;
    }

    public Status create(Status status){
        StatusData statusResult = mapper.map(status, StatusData.class);
        StatusData saved = statusRepo.save(statusResult);
        return mapper.map(saved,Status.class);
    }

    public Status read(Integer id){
        return mapper.map(statusRepo.findById(id)
            .orElseThrow(()-> new RuntimeException("Status not found with id: " + id)),Status.class);
    }

    public List<Status> readAll(){
        List<Status> allStatus = new ArrayList<Status>();
        for(StatusData data:statusRepo.findAll()){
            allStatus.add(mapper.map(data,Status.class));
        }
        return allStatus;
    }

    public Status update(int id,Status status){
        StatusData statusData = statusRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Status not found with id: " + id));
        status.setId(id);
        mapper.map(status,statusData);
        StatusData saved = statusRepo.save(statusData);
        return mapper.map(saved,Status.class);
    }

    public void delete(Integer id){
        if(!statusRepo.existsById(id)){
            throw new RuntimeException("Status not found with id: " + id);
        }
        statusRepo.deleteById(id);
    }
}
