package com.learning.studentRecruitment.repository;

import com.learning.studentRecruitment.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
