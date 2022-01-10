package com.example.mypkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mypkg.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
