package com.lilso.lireddit.repository;

import com.lilso.lireddit.model.Post;
import com.lilso.lireddit.model.User;
import com.lilso.lireddit.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
