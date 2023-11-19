package com.greatlearning.employeemanagementsystemrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.employeemanagementsystemrest.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
