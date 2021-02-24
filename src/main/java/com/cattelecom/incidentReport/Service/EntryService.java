package com.cattelecom.incidentReport.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cattelecom.incidentReport.Model.Entry;
import com.cattelecom.incidentReport.Model.Status;
import com.cattelecom.incidentReport.Repository.EntryRepository;
import com.cattelecom.incidentReport.Repository.StatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryService implements EntryServiceImpl {
    
    @Autowired
    EntryRepository entryRepository;

    @Autowired
    StatusRepository statusRepository;

    public Map<Status, List<Entry>> getGroupedEntries(){
        List<Entry> entries = entryRepository.findAll();
        List<Status> statuses = statusRepository.findAll();

        Map<Status, List<Entry>> map = new HashMap<>();
        for (Status status : statuses){
            map.put(status, new ArrayList<Entry>());
        }
        for (Entry entry : entries) {
            map.get(entry.getStatus()).add(entry);
        }

        return map;
    }

}
