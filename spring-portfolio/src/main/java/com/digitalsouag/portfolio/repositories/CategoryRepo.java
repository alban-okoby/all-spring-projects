package com.digitalsouag.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalsouag.portfolio.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
