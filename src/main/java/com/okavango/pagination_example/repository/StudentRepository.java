package com.okavango.pagination_example.repository;

import com.okavango.pagination_example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
