package com.cattelecom.incidentReport.Service;

import java.util.ArrayList;
import java.util.List;

import com.cattelecom.incidentReport.Model.Status;
import com.cattelecom.incidentReport.Repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService implements StatusServiceImpl {
    
    @Autowired
    StatusRepository statusRepository;
    
    public List<Status> getSortedStatus(){
        return statusRepository.findByOrderByIdAsc();
    }
}
