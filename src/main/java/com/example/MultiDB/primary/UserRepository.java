package com.example.MultiDB.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Object saveUser(User user);
	
	Object findUser(User user);

}
