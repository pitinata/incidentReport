package com.cattelecom.incidentReport.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter @Setter @ToString
public class Entry {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private @NotEmpty String topic;
    private @Column(length=10000) String description;    
    private @NotNull @ManyToOne Status status;
    private @NotNull @DateTimeFormat(pattern="yyyy-MM-dd") Date duedate;
    private @CreatedDate Date createdDate;
    private @LastModifiedDate Date updatedDate;

}
