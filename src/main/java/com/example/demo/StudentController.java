package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StudentController {

    @RequestMapping("/new_student") // new_student is the new path, get that
    public String newStudent(Model model) {
        model.addAttribute("grades", Grade.values());
        return "new_student";
    }

    @RequestMapping(path = "/create_student")
    public String createStudent(@RequestParam(value="first_name") String firstName, @RequestParam(value="last_name") String lastName, @RequestParam(value ="grade") String grade, Model model) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setGrade(Grade.valueOf(grade));
        model.addAttribute("student", student);

        return "view_student";
    }
}

