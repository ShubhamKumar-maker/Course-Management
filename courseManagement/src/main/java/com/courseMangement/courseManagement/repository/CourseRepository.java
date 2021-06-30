package com.courseMangement.courseManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.courseMangement.courseManagement.entities.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
		public List<CourseEntity>findByLocation(String location);
}
