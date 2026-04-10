package com.student.service;

/* =====================
Service: StudentService.java
===================== */



import java.awt.print.Pageable;
import java.util.List;
import com.student.entity.Student;
import com.student.entity.User;
import org.springframework.data.domain.Page;

public interface StudentService {

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student saveStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

}
