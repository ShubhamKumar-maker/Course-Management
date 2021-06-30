package com.courseMangement.courseManagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.courseMangement.courseManagement.entities.CourseEntity;
import com.courseMangement.courseManagement.models.Course;
import com.courseMangement.courseManagement.repository.CourseRepository;
import com.courseMangement.courseManagement.util.Mapper;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courserepository;

	@Autowired
	private JavaMailSender mailSender;

	public void saveCourse() {

	}

	public List<Course> getCourse() {
		List<Course> lt = new ArrayList<>();
		courserepository.findAll().forEach(s -> {
			lt.add(Mapper.mapEntity(s));
		});
		return lt;

	}

	public Course getCourseById(long id) {
		if (courserepository.findById(id).isPresent()) {
			Optional<CourseEntity> entity = courserepository.findById(id);
			return Mapper.mapEntity(entity.get());

		}
		return null;
	}

	public List<Course> getCourseByLocation(String location) {
		List<Course> lt = new ArrayList<>();
		courserepository.findByLocation(location).forEach(l -> {
			lt.add(Mapper.mapEntity(l));
		});
		return lt;
	}

	public Course addNewCourses(Course course) {
		CourseEntity courseentity=Mapper.mapObject(course);
		CourseEntity entity = courserepository.save(courseentity);
		return Mapper.mapEntity(entity);
	}

	public Course updateCourse(Course course, long id) {
		if (!courserepository.findById(id).isEmpty()) {
			CourseEntity entity = courserepository.save(Mapper.mapObject(course));
			return Mapper.mapEntity(entity);
		}
		return null;
	}

	public int deleteCourse(long id) {
		if (!courserepository.findById(id).isEmpty()) {
			courserepository.deleteById(id);
			return 1;
		}
		return 0;
	}

	public void sendMail(String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(getparticipantsData());
		message.setFrom("r06744423@gmail.com");
		message.setSubject(subject);
		message.setText(body);
		mailSender.send(message);
		System.out.println("mail send");
	}

	public String[] getparticipantsData() {

		RestTemplate resttemplate = new RestTemplate();
		String baseURL = "http://localhost:8901/testParticipants/getparticipantsEmail";
		ResponseEntity<String> response = null;
		response = resttemplate.exchange(baseURL, HttpMethod.GET, getHeaders(), String.class);
		String participantsEmail = response.getBody().toString();
		participantsEmail = participantsEmail.replace('"', ' ');
		participantsEmail = participantsEmail.replace('[', ' ');
		participantsEmail = participantsEmail.replace(']', ' ');
		participantsEmail = participantsEmail.trim();
		String[] email = participantsEmail.split(",");
		System.out.println("email is println");
		System.out.println(email);
		return email;
	}

	private static HttpEntity getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
}
