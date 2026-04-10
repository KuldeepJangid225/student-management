package com.student.controller;



import com.student.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.student.entity.Student;
import com.student.service.StudentService;

import java.awt.print.Pageable;


@Controller
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }


    @GetMapping("/new")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "create_student";
    }


    @PostMapping
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }


    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }



    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student) {

        Student existing = studentService.getStudentById(id);

        existing.setFirstName(student.getFirstName());
        existing.setLastName(student.getLastName());
        existing.setEmail(student.getEmail());
        existing.setPhone_Number(student.getPhone_Number());
        existing.setAddress(student.getAddress());
        existing.setDob(student.getDob());
        existing.setFatherName(student.getFatherName());
        existing.setMotherName(student.getMotherName());
        existing.setClassName(student.getClassName());

        studentService.updateStudent(existing);
        return "redirect:/students";
    }


    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

}


