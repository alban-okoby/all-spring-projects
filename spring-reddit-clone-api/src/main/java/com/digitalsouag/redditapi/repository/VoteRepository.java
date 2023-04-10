package com.digitalsouag.redditapi.repository;

import com.digitalsouag.redditapi.entity.Post;
import com.digitalsouag.redditapi.entity.User;
import com.digitalsouag.redditapi.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}