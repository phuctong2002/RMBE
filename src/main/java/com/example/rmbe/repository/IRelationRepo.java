package com.example.rmbe.repository;

import com.example.rmbe.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRelationRepo extends JpaRepository<Relation, Integer> {
    @Query(value = "SELECT * FROM quan_he WHERE ho_khau = :id", nativeQuery = true)
    List<Relation> getByDepartment(@Param("id") int id);
}
