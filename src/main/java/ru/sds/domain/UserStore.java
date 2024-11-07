package ru.sds.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class UserStore {
    private final ConcurrentHashMap<String, Student> users = new ConcurrentHashMap<>();

    public void save(Student student) {
        users.put(student.getLogin(), student);
    }


    public Student findByUsername(String username) {
        return users.get(username);
    }

    public List<Student> findAll() {
        return new ArrayList<>(users.values());
    }
}
