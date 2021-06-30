package com.courseMangement.courseManagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.courseMangement.courseManagement.entities.CourseEntity;
import com.courseMangement.courseManagement.repository.CourseRepository;
import com.courseMangement.courseManagement.utils.SetData;

@SpringBootTest
@AutoConfigureMockMvc
public class TestController {
	
	@Autowired 
	 private MockMvc mvc;
	
	@Mock
	private CourseRepository courseRepo;
	
	@Test
	public void testgetDataEndpoint() throws Exception
	{
		List<CourseEntity>ltcourseEntity=new ArrayList<>();
		ltcourseEntity.add(SetData.setcourseEntitydata());
		Mockito.when(courseRepo.findAll()).thenReturn(ltcourseEntity);
		 MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/test/getcourses").accept(MediaType.APPLICATION_JSON)).andReturn();
		 MockHttpServletResponse response = result.getResponse();
		 assertEquals(HttpStatus.OK.value(), response.getStatus());
	}
	
	@Test
	public void testgetByLocation() throws Exception
	{
		List<CourseEntity>ltcourseEntity=new ArrayList<>();
		ltcourseEntity.add(SetData.setcourseEntitydata());
		Mockito.when(courseRepo.findByLocation("Banglore")).thenReturn(ltcourseEntity);
		 MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/test/getcoursebylocation/Banglore").accept(MediaType.APPLICATION_JSON)).andReturn();
		 MockHttpServletResponse response = result.getResponse();
		 assertEquals(HttpStatus.OK.value(), response.getStatus());
		
	}

}
