package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "`TypeQuestion`", uniqueConstraints = @UniqueConstraint(columnNames = { "TypeName" }))
public class TypeQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "TypeName", length = 50, nullable = false, unique = true , insertable = true,updatable = true)
	private int name;
	
	@Formula("concat(TypeName,'_',TypeID)")
	private String newName;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	@Override
	public String toString() {
		return "TypeQuestion [id = " + id + ", name = " + name + ", newName = " + newName + "]";
	}

	
}
