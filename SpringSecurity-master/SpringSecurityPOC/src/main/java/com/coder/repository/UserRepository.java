package com.coder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coder.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

		@Query("select u from User u"
			      + " left join fetch u.authorities"
			      + " where u.username = :username")
		User findByUsername(String username);

	
}
