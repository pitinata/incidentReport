package com.cattelecom.incidentReport.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Map<Status, List<Entry>> getGroupedEntries() {
        List<Entry> entries = entryRepository.findAllByOrderByDuedateAsc();
        List<Status> statuses = statusRepository.findAll();

        Map<Status, List<Entry>> map = new HashMap<>();
        for (Status status : statuses) {
            map.put(status, new ArrayList<Entry>());
        }
        for (Entry entry : entries) {
            map.get(entry.getStatus()).add(entry);
        }

        return map;
    }

    public Entry getEntry(Long id) {
        Entry entry = entryRepository.findById(id).orElse(new Entry());
        return entry;
    }

    public Entry save(Entry input){
        return entryRepository.save(input);
    }

    public Entry update(Entry input){
        Entry entry = entryRepository.findById(input.getId()).orElse(new Entry());

        if(entry.getId() != 0){
            entryRepository.save(input);
        }
        
        return entry;
    }

    public boolean delete(Long id){
        Entry entry = entryRepository.findById(id).orElse(new Entry());
        
        if(entry.getId() == 0){
            return false;
        }
        entryRepository.delete(entry);
        return true;
    }

}
