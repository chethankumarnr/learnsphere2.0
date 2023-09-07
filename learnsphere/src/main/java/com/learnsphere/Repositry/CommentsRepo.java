package com.learnsphere.Repositry;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnsphere.Entities.Comments;
@Repository
public interface CommentsRepo extends JpaRepository<Comments, Long> {

	List<Comments> findByUserid(Long id);
}
