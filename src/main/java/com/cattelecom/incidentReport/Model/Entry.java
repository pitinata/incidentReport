package com.cattelecom.incidentReport.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter @Setter @ToString
public class Entry {

    private @Id @GeneratedValue Long id;
    private String topic;
    private @Column(length=10000) String description;    
    private @ManyToOne Status status;
    private Date duedate;
    private @CreatedDate Date createdDate;
    private @LastModifiedDate Date updatedDate;

}
