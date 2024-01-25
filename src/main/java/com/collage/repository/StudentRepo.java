package com.collage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.collage.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE Student s SET s.name = :newName WHERE s.name = :oldName" ,nativeQuery = true)
    int updateName(@Param("oldName") String oldName, @Param("newName") String newName);
}
