package com.digitalsouag.portfolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalsouag.portfolio.entities.Comment;

public interface CommentRepo  extends JpaRepository<Comment	, Integer> {

}
