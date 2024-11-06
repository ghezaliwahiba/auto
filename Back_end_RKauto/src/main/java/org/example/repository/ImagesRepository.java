package org.example.repository;

import org.example.model.images;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<images, Long> {}