package com.vti.entity;
 
import java.io.Serializable;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Formula;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import java.io.Serializable;


 
@Entity
@Table(name = "Position", uniqueConstraints = @UniqueConstraint(columnNames = { "PositionName" }))
public class Position implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
 
 
    @Column(name = "PositionName", nullable = false)
	@Enumerated(EnumType.STRING)
    private PositionName positionName;
 
    @Formula("concat(PositionName,'_',PositionID)")
	private String newName;
    
    public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public Position() {
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(short id) {
        this.id = id;
    }
    
    public PositionName getPositionName() {
		return positionName;
	}

	public void setPositionName(PositionName positionName) {
		this.positionName = positionName;
	}


	@Override
	public String toString() {
		return "Position [id = " + id + ", positionName = " + positionName + ", newName = " + newName + "]";
	}


	public enum PositionName {
    	DEV, TEST, SCRUMMASTER, PM
	}
}