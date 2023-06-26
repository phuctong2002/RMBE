package com.example.rmbe.repository;

import com.example.rmbe.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAbsenceRepo extends JpaRepository<Absence, Integer> {
}
