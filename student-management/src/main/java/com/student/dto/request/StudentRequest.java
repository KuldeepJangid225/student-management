package com.student.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {


    private String firstName;
    private String lastName;
    private String email;
    private String phone_Number;
    private String address;
    private String dob;
    private String fatherName;
    private String motherName;
    private String className;

}
