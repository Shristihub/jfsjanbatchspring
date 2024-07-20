package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.JwtUser;

@Repository
public interface IJwtUserRepository extends JpaRepository<JwtUser, Integer> {

	JwtUser findByUsername(String username);
}
