package com.learnsphere.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnsphere.Entities.Comments;
import com.learnsphere.Repositry.CommentsRepo;
import com.learnsphere.Repositry.LessonRepo;
import com.learnsphere.Sessiion.Session;

@Service
public class CommentsService {
@Autowired
CommentsRepo cmr;
@Autowired
LessonRepo lr;


public void addCommentQuestion(Long lessonId, String comment) {
	Comments c = new Comments();
	c.setLesson(lr.findById(lessonId).get());
	c.setScomment(comment);
	c.setUserid(Session.getId());
	cmr.save(c);
}


public void addans(Long cmid, String tcomment) {
	Comments c = cmr.findById(cmid).get();
	c.setTcomment(tcomment);
	cmr.save(c);
}




	
}
