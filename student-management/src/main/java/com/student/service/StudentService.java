package com.student.service;

/* =====================
Service: StudentService.java
===================== */



import java.util.List;
import com.student.entity.Address;

public interface StudentService {

    List<Address> getAllStudents();

    Address getStudentById(Long id);

    Address saveStudent(Address student);

    Address updateStudent(Address student);

    void deleteStudentById(Long id);

}
