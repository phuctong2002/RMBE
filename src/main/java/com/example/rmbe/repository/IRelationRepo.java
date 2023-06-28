package com.example.rmbe.repository;

import com.example.rmbe.entity.Department;
import com.example.rmbe.entity.Relation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRelationRepo extends JpaRepository<Relation, Integer> {
    @Query(value = "SELECT * FROM quan_he WHERE ho_khau = :id", nativeQuery = true)
    List<Relation> getByDepartment(@Param("id") int id);

    List<Relation> findByDepartment(Department department);
    @Modifying
    @Query( value = "DELETE FROM quan_he where nhan_khau = :id", nativeQuery = true)
    @Transactional
    void deleteByPersonId(@Param("id") int id);
}
