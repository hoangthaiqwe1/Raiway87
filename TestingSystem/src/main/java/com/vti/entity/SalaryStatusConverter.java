package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Salary.SalaryName;;

@Converter(autoApply = true)
public class SalaryStatusConverter implements AttributeConverter<Salary.SalaryName, String> {

	public String convertToDatabaseColumn(SalaryName status) {
		if (status == null) {
			return null;
		}
		return status.getSalary();
	}

	public SalaryName convertToEntityAttribute(String sqlStatus) {
		if (sqlStatus == null) {
			return null;
		}
		return Salary.SalaryName.toEnum(sqlStatus);
	}

}
