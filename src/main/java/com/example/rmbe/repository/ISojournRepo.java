package com.example.rmbe.repository;

import com.example.rmbe.entity.Sojourn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISojournRepo extends JpaRepository<Sojourn, Integer> {
}
