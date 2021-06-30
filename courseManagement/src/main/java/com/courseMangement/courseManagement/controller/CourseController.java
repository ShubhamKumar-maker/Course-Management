package com.courseMangement.courseManagement.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseMangement.courseManagement.entities.CourseEntity;
import com.courseMangement.courseManagement.models.Course;
import com.courseMangement.courseManagement.models.MailStrructure;
import com.courseMangement.courseManagement.service.CourseService;


@RestController
@RequestMapping("/test")
public class CourseController {

	@Autowired
	private CourseService courseservice;

	@GetMapping("/getcourses")
	public ResponseEntity<List<Course>> getAllCourses() {
		return new ResponseEntity<>(courseservice.getCourse(), HttpStatus.OK);

	}
	@GetMapping("/getcourse/{id}")
	public ResponseEntity<Course>getById(@PathVariable long id)
	{
		Course result=courseservice.getCourseById(id);
		if(result!=null) {
		return new ResponseEntity<>(result,HttpStatus.OK);}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}

	@GetMapping("/getcoursebylocation/{location}")
	public List<Course>getbylocation(@PathVariable String location)
	{
		return courseservice.getCourseByLocation(location);
	}

	@PutMapping("/courses-update/{id}")
	public ResponseEntity<Course> update(@RequestBody Course course, @PathVariable long id) {
		Course result=courseservice.updateCourse(course,id);
		if(result!=null)
		{
		return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	}

	@PostMapping("/courses-add")
	public ResponseEntity<Course> add(@RequestBody Course course) {
		return new ResponseEntity<>(courseservice.addNewCourses(course), HttpStatus.OK);
	}

	@DeleteMapping("/course-delete/{id}")
	public void delete(@PathVariable long id) {
		try {
			courseservice.deleteCourse(id);
			//return new ResponseEntity<>("Course get Deleted",HttpStatus.OK);
		}
		catch(Exception e){
			//return new ResponseEntity<>("error",HttpStatus.EXPECTATION_FAILED);
		}
	}
	@PostMapping("/sendmail")
	public void sendmailtoParticipants(@RequestBody MailStrructure mailstr)
	{
		System.out.println(mailstr);
		courseservice.sendMail(mailstr.getSubject(), mailstr.getBody());
	}
	


}
