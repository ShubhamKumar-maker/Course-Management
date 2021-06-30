package com.courseMangement.courseManagement.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.courseMangement.courseManagement.entities.CourseEntity;
import com.courseMangement.courseManagement.entities.Creator;
import com.courseMangement.courseManagement.entities.Skill;
import com.courseMangement.courseManagement.models.Course;

public class SetData {
	
	public static CourseEntity setcourseEntitydata()
	{
		CourseEntity cenitydata=new CourseEntity();
		Creator crdata=new Creator();
		Skill sdata=new Skill();
		crdata.setId(1);
		crdata.setName("shubham");
		sdata.setId(1);
		sdata.setName("c");
		List<Creator> ltcreator= new ArrayList<>();
		ltcreator.add(crdata);
		List<Skill> ltskill=new ArrayList<>();
		ltskill.add(sdata);
		cenitydata.setId(100l);
		cenitydata.setDescription("CPP");
		cenitydata.setFeedback("good");
		cenitydata.setPrerequesite("Engineering");
		cenitydata.setLocation("Banglore");
		cenitydata.setCreator(ltcreator);
		cenitydata.setSkill(ltskill);
		return cenitydata;
	}
	public static Course setCourse()
	{
		Course courseData=new Course();
		Creator crdata=new Creator();
		Skill sdata=new Skill();
		crdata.setId(1);
		crdata.setName("shubham");
		sdata.setId(1);
		sdata.setName("c");
		List<Creator> ltcreator= new ArrayList<>();
		ltcreator.add(crdata);
		List<Skill> ltskill=new ArrayList<>();
		ltskill.add(sdata);
		courseData.setId(100l);
		courseData.setDescription("CPP");
		courseData.setFeedback("good");
		courseData.setPrerequesite("Engineering");
		courseData.setLocation("Banglore");
		courseData.setCreator(ltcreator);
		courseData.setSkill(ltskill);
		
		return courseData;
	}
	public static Optional<CourseEntity> setcourseEntitydata2()
	{
		CourseEntity cenitydata=new CourseEntity();
		Creator crdata=new Creator();
		Skill sdata=new Skill();
		crdata.setId(1);
		crdata.setName("shubham");
		sdata.setId(1);
		sdata.setName("c");
		List<Creator> ltcreator= new ArrayList<>();
		ltcreator.add(crdata);
		List<Skill> ltskill=new ArrayList<>();
		ltskill.add(sdata);
		cenitydata.setId(100l);
		cenitydata.setDescription("CPP");
		cenitydata.setFeedback("good");
		cenitydata.setPrerequesite("Engineering");
		cenitydata.setLocation("Banglore");
		cenitydata.setCreator(ltcreator);
		cenitydata.setSkill(ltskill);
		return Optional.of(cenitydata);
	}

}
