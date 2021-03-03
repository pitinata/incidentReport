package com.cattelecom.incidentReport.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Status {
    
    private @Id int id;
    private @NotEmpty String name;
    private @NotEmpty String colorcode;
}
