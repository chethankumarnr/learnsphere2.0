package com.learnsphere.Entities;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Comments {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long commentid;

@ManyToOne
public Lesson lesson;

public String scomment;

public String tcomment;

public Long userid;

public Long getCommentid() {
	return commentid;
}

public void setCommentid(Long commentid) {
	this.commentid = commentid;
}

public Lesson getLesson() {
	return lesson;
}

public void setLesson(Lesson lesson) {
	this.lesson = lesson;
}

public Long getUserid() {
	return userid;
}

public void setUserid(Long userid) {
	this.userid = userid;
}

public String getScomment() {
	return scomment;
}

public void setScomment(String scomment) {
	this.scomment = scomment;
}

public String getTcomment() {
	return tcomment;
}

public void setTcomment(String tcomment) {
	this.tcomment = tcomment;
}

public Comments(Long commentid, Lesson lesson, Long userid, String scomment, String tcomment) {
	super();
	this.commentid = commentid;
	this.lesson = lesson;
	this.userid = userid;
	this.scomment = scomment;
	this.tcomment = tcomment;
}

public Comments() {
	super();
}



}
