package com.example.MultiDB.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.MultiDB.primary.User;

@Repository
public interface ProductRepository extends JpaRepository<User, Long>{

	Object saveUser(User user);
	
	Object findById(User user);
}
