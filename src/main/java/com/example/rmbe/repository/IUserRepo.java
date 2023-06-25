package com.example.rmbe.repository;

import com.example.rmbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {
    User findByUsername( String username );
    User findByUsernameAndPassword( String username, String password );
}
