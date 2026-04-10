package com.student.repository;
import com.student.entity.Student;

import com.student.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;


public interface StudentRepository extends JpaRepository<Student, Long> {

}