package com.hizon.services;
import java.util.List;
import com.hizon.model.Status;

public interface StatusService {
    List<Status> readAll() throws Exception;
    Status create(Status status) throws Exception;
    Status read(Integer id) throws Exception;
    Status update(Status status) throws Exception;
    void delete(Integer id) throws Exception;
}
