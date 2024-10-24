package com.example.demo.repository;

import com.example.demo.db.entity.Pictures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PicturesRepository extends JpaRepository<Pictures,Long> {
}
