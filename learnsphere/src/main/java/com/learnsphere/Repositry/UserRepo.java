package com.learnsphere.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learnsphere.Entities.Users;

public interface UserRepo extends JpaRepository<Users,Long> {
	public boolean existsByEmail(String email);
	public Users findByEmail(String Email);
	public Users getByEmail(String email);
}


