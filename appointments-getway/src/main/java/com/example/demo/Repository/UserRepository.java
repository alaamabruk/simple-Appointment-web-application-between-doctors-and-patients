package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByUsername(String username);

	Optional<User> findByUsernameAndPassword(String username, String password);
}
