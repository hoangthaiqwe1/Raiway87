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
 
@Entity
@Table(name = "Position", uniqueConstraints = @UniqueConstraint(columnNames = { "PositionName" }))
public class Position implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
 
    @Column(name = "PositionName", length = 50, nullable = false, updatable = true,insertable = true)
    private String name;
 
    @Formula("concat(PositionName, '_', PositionID)")
    private String newName;
 
    public Position() {
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(short id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getNewName() {
        return newName;
    }
 
    @Override
    public String toString() {
        return "Position [id = " + id + ", name = " + name + ", newName = " + newName + "]";
    }
}