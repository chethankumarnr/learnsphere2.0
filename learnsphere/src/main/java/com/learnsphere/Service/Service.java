package com.learnsphere.Service;

import com.learnsphere.Entities.Users;

public interface Service {
public void save(Users u);
public boolean emailExists(String email);
public Users findByEmail(String Email);
public Users getByEmail(String email);
}
