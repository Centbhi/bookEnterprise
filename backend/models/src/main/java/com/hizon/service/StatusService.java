package com.hizon.service;
import java.util.List;
import com.hizon.model.Status;

public interface StatusService {
    List<Status> readAll() throws Exception;
    void create(Status status) throws Exception;
    Status read(Integer id) throws Exception;
    void update(Status status) throws Exception;
    void delete(Integer id) throws Exception;
}
