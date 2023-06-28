package com.example.rmbe.repository;

import com.example.rmbe.entity.Dead;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IDeadRepo extends JpaRepository<Dead, Integer> {
    @Modifying
    @Query( value = "DELETE FROM khai_tu where nhan_khau = :id", nativeQuery = true)
    @Transactional
    void deleteByPersonId(@Param("id") int id);
}
