package com.example.rmbe.repository;

import com.example.rmbe.entity.Dead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeadRepo extends JpaRepository<Dead, Integer> {
}
