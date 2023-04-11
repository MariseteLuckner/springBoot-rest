package com.mari.demo.repository;

import com.mari.demo.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Parent findByName(String john);
}
