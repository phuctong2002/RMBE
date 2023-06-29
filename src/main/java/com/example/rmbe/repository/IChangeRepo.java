package com.example.rmbe.repository;

import com.example.rmbe.entity.Change;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IChangeRepo extends JpaRepository<Change, Integer> {
    List<Change> findByDepartmentId(int departmentId);
    @Modifying
    @Query( value = "DELETE FROM thay_doi where ho_khau = :id", nativeQuery = true)
    @Transactional
    void deleteByDepartmentId(@Param("id")int id);
}
