package com.okavango.pagination_example.service;

import com.okavango.pagination_example.entity.Student;
import com.okavango.pagination_example.entity.dto.StudentDTO;
import com.okavango.pagination_example.repository.StudentPaginationRepository;
import com.okavango.pagination_example.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentPaginationRepository studentPaginationRepository;


    public ResponseEntity<Student> save(Student student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(new Student(student.getId(),student.getName())));
    }

    @Transactional(readOnly = true)
    public StudentDTO<Student> returnAll( int pageNumber, int pageSize){

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Student> page = studentPaginationRepository.findAll(pageable);
        StudentDTO<Student> studentDTO = new StudentDTO<>();
        studentDTO.setContent(page.getContent());
        studentDTO.setSizePerPage(page.getSize());
        studentDTO.setTotalOfPages(page.getTotalPages());
        studentDTO.setActualPage(page.getNumber());
        return studentDTO;
    }

//    @Transactional(readOnly = true)
//    public Page<Student> returAll(int pageNumber, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNumber, pageSize);
//        return studentPaginationRepository.findAll(pageable);
//    }
}
