package com.hizon.serviceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.hizon.entity.StatusData;
import com.hizon.model.Status;
import com.hizon.service.StatusService;

@Service
public class StatusServiceImpl extends GenericServiceImpl<StatusData, Status> implements StatusService{
    public StatusServiceImpl(JpaRepository<StatusData,Integer> repo, ModelMapper mapper){
        super(repo,mapper,StatusData.class,Status.class);
    }
}
