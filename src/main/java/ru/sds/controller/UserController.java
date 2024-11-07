package ru.sds.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.sds.domain.Student;
import ru.sds.domain.UserStore;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserStore users;
    private BCryptPasswordEncoder encoder;

    public UserController(UserStore users,
                          BCryptPasswordEncoder encoder) {
        this.users = users;
        this.encoder = encoder;
    }

    @PostMapping("/sign-up")
    public void signUp(@RequestBody Student student) {
        student.setPassword(encoder.encode(student.getPassword()));
        users.save(student);
    }

    @GetMapping("/all")
    public List<Student> findAll() {
        return users.findAll();
    }
}
