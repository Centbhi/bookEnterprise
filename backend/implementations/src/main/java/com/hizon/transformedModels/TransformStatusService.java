package com.hizon.transformedModels;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.hizon.entity.StatusData;
import com.hizon.model.Status;
import com.hizon.repository.StatusRepository;

@Service
public class TransformStatusService {

    private final StatusRepository statusRepo;
    private final ModelMapper mapper;

    public TransformStatusService(StatusRepository statusRepo, ModelMapper mapper) {
        this.statusRepo = statusRepo;
        this.mapper = mapper;
    }

    public Status getStatus(Integer id){
        return mapper.map(statusRepo.findById(id).orElseThrow(
            ()-> new RuntimeException("Status not found")),Status.class);
    }

    public Status getStatus(Status status){
        return mapper.map(statusRepo.findById(status.getId()),Status.class);
    }

    public List<Status> getAll(){
        List<Status> allStatus = new ArrayList<Status>();
        for(StatusData data:statusRepo.findAll()){
            allStatus.add(mapper.map(data,Status.class));
        }
        return allStatus;
    }

    public StatusData transformStatus(Status status){
        return mapper.map(status,StatusData.class);
    }
    
}
