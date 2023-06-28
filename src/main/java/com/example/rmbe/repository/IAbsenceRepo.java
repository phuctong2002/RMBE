package com.example.rmbe.repository;

import com.example.rmbe.entity.Absence;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAbsenceRepo extends JpaRepository<Absence, Integer> {
    @Modifying
    @Query( value = "DELETE FROM tam_vang where nhan_khau = :id", nativeQuery = true)
    @Transactional
    void deleteByPersonId(@Param("id") int id);
}
