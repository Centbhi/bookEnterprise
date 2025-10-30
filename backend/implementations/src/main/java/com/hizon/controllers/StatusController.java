package com.hizon.controllers;

import org.springframework.web.bind.annotation.*;
import com.hizon.model.Status;
import com.hizon.service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController extends GenericController<Status>{
    public StatusController(StatusService service){
        super(service);
    }
}