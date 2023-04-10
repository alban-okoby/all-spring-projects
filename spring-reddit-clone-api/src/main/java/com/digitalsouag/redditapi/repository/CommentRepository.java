package com.digitalsouag.redditapi.repository;

import com.digitalsouag.redditapi.entity.Comment;
import com.digitalsouag.redditapi.entity.Post;
import com.digitalsouag.redditapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
