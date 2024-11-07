package ru.sds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.sds.domain.Student;

import java.util.List;

@Component
public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Override
    List<Student> findAll();
    Student findStudentByLogin(String username);
}
