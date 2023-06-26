package com.example.rmbe.repository;

import com.example.rmbe.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepo extends JpaRepository<Department, Integer> {

    Department findFirstById(int department_id);
}
