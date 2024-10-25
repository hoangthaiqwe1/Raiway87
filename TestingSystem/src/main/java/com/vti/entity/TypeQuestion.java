package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import com.vti.entity.Position.PositionName;

@Entity
@Table(name = "`TypeQuestion`", uniqueConstraints = @UniqueConstraint(columnNames = { "TypeName" }))
public class TypeQuestion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "TypeName", nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TypeName typeName;

	@Formula("concat(TypeName,'_',TypeID)")
	private String newName;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}


	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	public TypeName getTypeName() {
		return typeName;
	}

	public void setTypeName(TypeName typeName) {
		this.typeName = typeName;
	}


    public enum TypeName {
    	ESSAY, MUTIPLECHOICE;
	}


	@Override
	public String toString() {
		return "TypeQuestion [id = " + id + ", typeName = " + typeName + ", newName = " + newName + "]";
	}
	
}
