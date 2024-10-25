package com.vti.entity;

import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import com.vti.repository.ExamRepository;

public class ExamCodeGenerator implements IdentifierGenerator {
    private ExamRepository repository;

    public ExamCodeGenerator() {
        repository = new ExamRepository();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object)
            throws HibernateException {
        Exam exam = (Exam) object;
        int duration = exam.getDuration();
        int count = repository.getCountByType(duration);
        String typePrefix;

        if (duration >= 180) {
            typePrefix = "L"; // Long
        } else if (duration >= 90) {
            typePrefix = "M"; // Medium
        } else {
            typePrefix = "S"; // Short
        }

        return typePrefix + "-" + count;
    }
}
