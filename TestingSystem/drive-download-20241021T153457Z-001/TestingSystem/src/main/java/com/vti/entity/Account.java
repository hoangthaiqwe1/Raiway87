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
@Table(name = "`Account`", uniqueConstraints = @UniqueConstraint(columnNames = { "Email","Username","FirstName","LastName" }))
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;
	
	
	@Column(name = "Email", length = 50, nullable = false, unique = true , insertable = true,updatable = true)
	private String email;
	
	@Column(name = "Username", length = 50, nullable = false, unique = true , insertable = true,updatable = true)
	private String name;
	
	@Column(name = "FirstName", length = 50, nullable = false, unique = true , insertable = true,updatable = true)
	private String firstName;
	
	@Column(name = "LastName", length = 50, nullable = false, unique = true , insertable = true,updatable = true)
	private String lastName;
	
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date CreateDate;
	
	@Formula("concat(Username,'_',AccountID)")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return "Account [id = " + id + ", email = " + email + ", name = " + name + ", firstName = " + firstName + ", lastName = "
				+ lastName + ", CreateDate = " + CreateDate + ", newName = " + newName + "]";
	}
	
	
	
}
