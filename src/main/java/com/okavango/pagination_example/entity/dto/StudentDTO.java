package com.okavango.pagination_example.entity.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO <T>{

    private List<T> content;
    private int sizePerPage;
    private int totalOfPages;
    private int actualPage;
}
