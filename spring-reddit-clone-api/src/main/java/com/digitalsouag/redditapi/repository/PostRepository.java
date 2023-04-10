package com.digitalsouag.redditapi.repository;

import com.digitalsouag.redditapi.entity.Post;
import com.digitalsouag.redditapi.entity.Subreddit;
import com.digitalsouag.redditapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
