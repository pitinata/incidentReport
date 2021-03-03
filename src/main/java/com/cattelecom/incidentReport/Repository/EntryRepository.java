package com.cattelecom.incidentReport.Repository;

import java.util.List;

import com.cattelecom.incidentReport.Model.Entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

	List<Entry> findAllByOrderByDuedateAsc();
    
}
