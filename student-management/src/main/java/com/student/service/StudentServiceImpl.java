package com.student.service;

import java.awt.print.Pageable;
import java.util.List;

import com.student.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.student.entity.Student;
import com.student.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;


    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }


    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
