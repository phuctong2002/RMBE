package com.example.rmbe.repository;

import com.example.rmbe.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPaymentRepo extends JpaRepository<Payment, Integer> {
    @Query(value = "SELECT * FROM dong_tien WHERE khoan_thu = :id", nativeQuery = true)
    List<Payment> findByEventId(@Param("id") int id);
}
