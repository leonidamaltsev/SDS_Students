package ru.sds.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sds.domain.Student;
import ru.sds.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository students;

    public StudentController(final StudentRepository students) {
        this.students = students;
    }

    @GetMapping("/")
    public List<Student> findAll() {
        return (List<Student>) this.students.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable int id) {
        var student = this.students.findById(id);
        return new ResponseEntity<Student>(
                student.orElse(new Student()),
                student.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @PostMapping("/")
    public ResponseEntity<Student> create(@RequestBody Student student) {
        return new ResponseEntity<Student>(
                this.students.save(student),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Void> update(@RequestBody Student student) {
        this.students.save(student);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Student student = new Student();
        student.setId(id);
        this.students.delete(student);
        return ResponseEntity.ok().build();
    }
}
