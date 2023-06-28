package com.example.rmbe.repository;

import com.example.rmbe.entity.Donation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDonationRepo extends JpaRepository<Donation, Integer> {
    @Modifying
    @Query( value = "DELETE FROM dong_khoan_dong_gop where ho_khau = :id", nativeQuery = true)
    @Transactional
    void deleteByDepartmentId(@Param("id") int id);
    @Query( value = "SELECT * FROM dong_khoan_dong_gop where khoan_dong_gop = :id", nativeQuery = true)
    List<Donation> findByEventId(@Param("id") int id);
}
