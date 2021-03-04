package com.cattelecom.incidentReport.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authorities")
public class Authority implements Serializable{
    
    @Id
    @NotNull
    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    @NotNull
    private String authority;
    

}
