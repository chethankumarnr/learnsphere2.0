package com.learnsphere.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long LessonId;
	
	public String topics;
	
	public String link;
	
	@ManyToOne
	public Course course;

	 @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
	public List<Comments> comments;
	
	public Long getLessonId() {
		return LessonId;
	}

	public void setLessonId(Long lessonId) {
		LessonId = lessonId;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Lesson(Long lessonId, String topics, String link, Course course) {
		super();
		LessonId = lessonId;
		this.topics = topics;
		this.link = link;
		this.course = course;
	}

	public Lesson() {
		super();
	}

}
