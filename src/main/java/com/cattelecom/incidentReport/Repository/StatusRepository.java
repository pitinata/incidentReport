package com.cattelecom.incidentReport.Repository;

import java.util.List;

import com.cattelecom.incidentReport.Model.Status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
    List<Status> findByOrderByIdAsc();
}
