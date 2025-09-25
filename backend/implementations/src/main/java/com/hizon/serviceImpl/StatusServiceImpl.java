package com.hizon.serviceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hizon.entity.StatusData;
import com.hizon.model.Status;
import com.hizon.service.StatusService;
import com.hizon.transformedModels.TransformStatusService;
import com.hizon.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{
    
    private TransformStatusService transformedStatus;
    private StatusRepository statusRepo;
    @Autowired
    public StatusServiceImpl(TransformStatusService transformedStatus,StatusRepository statusRepo){
        this.transformedStatus = transformedStatus;
        this.statusRepo = statusRepo;
    }

    public void create(Status status){
        System.out.println("Status Created: " + statusRepo.save(transformedStatus.transformStatus(status)));
    }

    public Status read(Integer id){
        return transformedStatus.getStatus(id);
    }
    public List<Status> readAll(){
        return transformedStatus.getAll();
    }

    public void update(Status status){
        System.out.println("Status Before Update: " + transformedStatus.getStatus(status));
        StatusData saved = statusRepo.save(transformedStatus.transformStatus(status));
        System.out.println("Status After Update: " + saved);
    }

    public void delete(Integer id){
        statusRepo.deleteById(id);
    }
}
