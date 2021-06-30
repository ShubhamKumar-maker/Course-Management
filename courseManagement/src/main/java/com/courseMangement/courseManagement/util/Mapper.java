package com.courseMangement.courseManagement.util;

import java.util.Date;

import com.courseMangement.courseManagement.entities.CourseEntity;
import com.courseMangement.courseManagement.models.Course;

public class Mapper {
	
	public static CourseEntity mapObject(Course course)
	{
		CourseEntity entity=new CourseEntity();
		entity.setId(course.getId());
		entity.setDescription(course.getDescription());
		entity.setFeedback(course.getFeedback());
		entity.setLocation(course.getLocation());
		entity.setPrerequesite(course.getPrerequesite());
		entity.setLastupdated(new Date());
		entity.setSkill(course.getSkill());
		entity.setCreator(course.getCreator());
		return entity;
		
	}
	
	public static Course mapEntity(CourseEntity courseEntity)
	{
		Course object =new Course();
		object.setId(courseEntity.getId());
		object.setDescription(courseEntity.getDescription());
		object.setFeedback(courseEntity.getFeedback());
		object.setLastupdated(courseEntity.getLastupdated());
		object.setLocation(courseEntity.getLocation());
		object.setSkill(courseEntity.getSkill());
		object.setCreator(courseEntity.getCreator());
		object.setPrerequesite(courseEntity.getPrerequesite());
		return object;
	}
	
	
	
	
	

}
