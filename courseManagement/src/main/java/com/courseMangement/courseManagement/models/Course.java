package com.courseMangement.courseManagement.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import com.courseMangement.courseManagement.entities.CourseEntity;
import com.courseMangement.courseManagement.entities.Creator;
import com.courseMangement.courseManagement.entities.Skill;

public class Course {
	private Long id;
	private String description;
	private String prerequesite;
	private String feedback;
	private String location;
	private Date lastupdated;
	private List<Skill>skill;
	private List<Creator>creator;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrerequesite() {
		return prerequesite;
	}
	public void setPrerequesite(String prerequesite) {
		this.prerequesite = prerequesite;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}
	public List<Skill> getSkill() {
		return skill;
	}
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}
	public List<Creator> getCreator() {
		return creator;
	}
	public void setCreator(List<Creator> creator) {
		this.creator = creator;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", description=" + description + ", prerequesite=" + prerequesite + ", feedback="
				+ feedback + ", location=" + location + ", lastupdate=" + lastupdated + ", skill=" + skill + ", creator="
				+ creator + "]";
	}
	public Date getLastupdated() {
		return lastupdated;
	}
	
	
}
