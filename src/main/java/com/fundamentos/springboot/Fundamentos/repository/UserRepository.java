package com.fundamentos.springboot.Fundamentos.repository;

import com.fundamentos.springboot.Fundamentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
