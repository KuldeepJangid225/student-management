package com.student.dto;



import lombok.Data;

@Data
public class UserFilterRequest {

    private String name;
    private String email;
    private String role;
    private Boolean active;

    // Pagination
    private int page = 0;
    private int size = 10;
}
