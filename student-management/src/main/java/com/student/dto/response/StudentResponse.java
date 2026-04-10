package com.student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private String firstName;
    private String lastName;
    private String phone_Number;
    private String address;
    private String dob;
    private String fatherName;
    private String motherName;
    private String className;

}
