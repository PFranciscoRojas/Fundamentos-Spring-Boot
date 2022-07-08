package com.fundamentos.springboot.Fundamentos.repository;

import com.fundamentos.springboot.Fundamentos.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {


}
