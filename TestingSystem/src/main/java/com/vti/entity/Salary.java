package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
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
import com.vti.entity.Salary.SalaryName;

@Entity
@Table(name = "`Salary`", uniqueConstraints = @UniqueConstraint(columnNames = { "SalaryName" }))
public class Salary implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "SalaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "SalaryName", nullable = false)
	@Convert(converter = SalaryStatusConverter.class)
	private SalaryName salaryName;


	@Formula("concat(SalaryName,'_',SalaryID)")
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


	public SalaryName getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName;
	}

	@Override
	public String toString() {
		return "Salary [id = " + id + ", salaryName = " + salaryName + ", newName = " + newName + "]";
	}


	public enum SalaryName {
		DEV("600"), TEST("700"), SCRUMMASTE("1500"), PM("2000");

		private String salary;

		private SalaryName(String salary) {
			this.salary = salary;
		}

		public String getSalary() {
			return salary;
		}

		public static SalaryName toEnum(String sqlStatus) {
			for (SalaryName item : SalaryName.values()) {
				if (item.getSalary().equals(sqlStatus)) {
					return item;
				}
			}
			return null;
		}
	}

}
