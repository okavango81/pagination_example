package com.okavango.pagination_example.repository;

import com.okavango.pagination_example.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentPaginationRepository extends PagingAndSortingRepository<Student, Long> {
}
