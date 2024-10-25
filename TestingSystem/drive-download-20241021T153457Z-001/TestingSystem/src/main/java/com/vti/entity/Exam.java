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
@Table(name = "`Exam`", uniqueConstraints = @UniqueConstraint(columnNames = { "`Code1`","`Code2`","Title","Duration" }))
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "ExamID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	@Column(name = "`Code1`", length = 50, nullable = false, unique = false , insertable = true,updatable = true)
	private String Code1;
	
	@Column(name = "`Code2`", length = 50, nullable = true, unique = false , insertable = true,updatable = true)
	private String Code2;

	@Column(name = "Title", length = 50, nullable = false, unique = true , insertable = true,updatable = true)
	private String name;
	
	@Column(name = "Duration", length = 50, nullable = false, unique = true , insertable = true,updatable = true)
	private int Duration;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date CreateDate;
	
	@Formula("concat(Title,'_',Duration)")
	private String newName;
	
	@PrePersist
	public void prepersist() {
		if(CreateDate == null) {
			CreateDate = new Date();
		}
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getCode1() {
		return Code1;
	}

	public void setCode1(String code1) {
		Code1 = code1;
	}

	public String getCode2() {
		return Code2;
	}

	public void setCode2(String code2) {
		Code2 = code2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	@Override
	public String toString() {
		return "Exam [id = " + id + ", Code1 = " + Code1 + ", Code2 = " + Code2 + ", name = " + name + ", Duration = " + Duration
				+ ", CreateDate = " + CreateDate + ", newName = " + newName + "]";
	}
	
}
