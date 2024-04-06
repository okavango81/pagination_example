package com.okavango.pagination_example.controller;

import com.okavango.pagination_example.entity.Student;
import com.okavango.pagination_example.entity.dto.StudentDTO;
import com.okavango.pagination_example.repository.StudentPaginationRepository;
import com.okavango.pagination_example.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final StudentPaginationRepository studentPaginationRepository;

    @PostMapping
    public ResponseEntity<Student> save(@Valid @RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping
    public StudentDTO<Student> findAll(@RequestParam(defaultValue = "0") int pageNumber,
                                       @RequestParam(defaultValue = "12") int pageSize) {
        return studentService.returnAll(pageNumber, pageSize);
    }

//    @GetMapping
//    public Page<Student> findAll(Pageable pageable) {
//        return studentPaginationRepository.findAll(pageable);
//    }
}
