package com.courseMangement.courseManagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.courseMangement.courseManagement.entities.Skill;



public interface SkillRepository extends CrudRepository<Skill, Long> {
	

}
