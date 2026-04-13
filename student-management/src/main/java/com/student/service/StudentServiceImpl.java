package com.student.service;


import java.util.List;


import org.springframework.stereotype.Service;
import com.student.entity.Address;
import com.student.repository.AddressRepository;


@Service
public class StudentServiceImpl implements StudentService {


    private final AddressRepository studentRepository;


    public StudentServiceImpl(AddressRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @Override
    public List<Address> getAllStudents() {
        return studentRepository.findAll();
    }


    @Override
    public Address saveStudent(Address student) {
        return studentRepository.save(student);
    }


    @Override
    public Address getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }


    @Override
    public Address updateStudent(Address student) {
        return studentRepository.save(student);
    }


    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
