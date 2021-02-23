package com.cattelecom.incidentReport.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Status {
    @Id
    private int id;
    private String name;
    private String colorcode;
}
