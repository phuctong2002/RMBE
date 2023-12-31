package com.example.rmbe.repository;

import com.example.rmbe.entity.Sojourn;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISojournRepo extends JpaRepository<Sojourn, Integer> {
    @Modifying
    @Query( value = "DELETE FROM tam_tru where ho_khau = :id", nativeQuery = true)
    @Transactional
    void deleteByDepartmentId(@Param("id") int id);
}
