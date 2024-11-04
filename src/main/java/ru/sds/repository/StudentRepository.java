package ru.sds.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sds.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
