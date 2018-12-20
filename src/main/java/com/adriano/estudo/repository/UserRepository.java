package com.adriano.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adriano.estudo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByName(String name);
}
